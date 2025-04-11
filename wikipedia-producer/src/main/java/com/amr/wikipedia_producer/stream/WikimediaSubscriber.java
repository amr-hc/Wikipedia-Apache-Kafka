package com.amr.wikipedia_producer.stream;

import com.amr.wikipedia_producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaSubscriber {

    private final WebClient webClient;
    private final WikimediaProducer wikimediaProducer;


    public WikimediaSubscriber(WebClient.Builder webClientBuilder, WikimediaProducer wikimediaProducer) {
        this.wikimediaProducer = wikimediaProducer;
        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2").build();
    }

    public void subsribeAndPublish(){
        webClient.get()
            .uri("/stream/recentchange")
            .retrieve()
            .bodyToFlux(String.class)
            .subscribe(wikimediaProducer::sendMessage);
    }

}

