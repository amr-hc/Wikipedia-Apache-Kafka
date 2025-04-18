package com.amr.wikipedia_consumer.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BootStrapreducer implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("✅ consumer is fully up");
    }
}
