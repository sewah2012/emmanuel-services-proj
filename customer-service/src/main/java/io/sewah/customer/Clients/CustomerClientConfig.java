package io.sewah.customer.Clients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerClientConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
