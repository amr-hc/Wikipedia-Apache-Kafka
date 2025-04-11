package com.amr.wikipedia_producer.runner;

import com.amr.wikipedia_producer.stream.WikimediaSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BootStrapreducer implements CommandLineRunner {

    private final WikimediaSubscriber wikimediaSubscriber;

    @Override
    public void run(String... args) {
        wikimediaSubscriber.subsribeAndPublish();
        System.out.println("✅ Subscribed is fully up");
    }
}
