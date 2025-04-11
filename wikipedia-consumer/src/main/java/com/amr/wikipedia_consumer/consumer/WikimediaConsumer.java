package com.amr.wikipedia_consumer.consumer;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Component
@RequiredArgsConstructor
public class WikimediaConsumer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    private FluxSink<String> sink;
    private Flux<String> stream;

    @PostConstruct
    public void init() {
        Flux<String> publisher = Flux.create(emitter -> this.sink = emitter, FluxSink.OverflowStrategy.BUFFER);
        this.stream = publisher.publish().autoConnect(); // share the same stream to all subscribers
    }

    public Flux<String> getStream() {
        return stream;
    }

    @KafkaListener(topics = "quickstart-events", groupId = "my-consumer-group")
    public void listen(String message) {
        if (sink != null) {
            sink.next(message);
        }
    }

}
