package com.amr.wikipedia_producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikimediaTopicConfig {
    @Bean
    public NewTopic wikiMediaTopic(){
        return TopicBuilder.name("wiki-media").build();
    }
}
