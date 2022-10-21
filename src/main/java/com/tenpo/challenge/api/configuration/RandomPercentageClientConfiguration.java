package com.tenpo.challenge.api.configuration;

import com.tenpo.challenge.api.client.RandomPercentageClient;
import com.tenpo.challenge.api.client.RandomPercentageRestClient;
import com.tenpo.challenge.api.client.cache.RandomPercentageClientCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomPercentageClientConfiguration {

    @Bean
    public RandomPercentageClient randomPercentageClient(RandomPercentageRestClient randomPercentageRestClient){
        return randomPercentageRestClient;
    }
}
