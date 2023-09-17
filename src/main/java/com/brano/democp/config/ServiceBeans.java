package com.brano.democp.config;

import com.brano.democp.service.ScoreAggregator;
import com.brano.democp.service.impl.ScoreAggregatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeans {

    @Bean
    public ScoreAggregator scoreAggregator() {
        return new ScoreAggregatorImpl();
    }

}
