package com.amr.wikipedia_consumer.controller;

import com.amr.wikipedia_consumer.consumer.WikimediaConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/stream")
@RequiredArgsConstructor
public class StreamController {

    private final WikimediaConsumer consumer;

    @GetMapping(value = "/wikipedia")
    public Flux<String> streamWikipediaMessages() {
        return consumer.getStream();
    }
}
