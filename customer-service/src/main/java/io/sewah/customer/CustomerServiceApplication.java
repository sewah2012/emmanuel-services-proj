package io.sewah.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "io.sewah.amqp",
                "io.sewah.customer"
        }
)
@EnableEurekaClient
@EnableFeignClients(basePackages = "io.sewah.clients")
public class CustomerServiceApplication{
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
