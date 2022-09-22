package com.paybek.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Bahodir Hasanov 9/22/2022 12:11 PM
@Configuration
public class CustomerConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
