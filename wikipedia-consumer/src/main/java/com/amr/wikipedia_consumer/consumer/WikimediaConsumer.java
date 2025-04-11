package com.amr.wikipedia_consumer.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class WikimediaConsumer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    @KafkaListener(topics = "quickstart-events", groupId = "my-consumer-group")
    public void listen(String message) {
        System.out.println("📥 Received message: " + message);
    }
}
