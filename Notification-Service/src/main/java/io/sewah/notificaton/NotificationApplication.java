package io.sewah.notificaton;

import io.sewah.amqp.config.RabbitMQMessageProducer;
import io.sewah.notificaton.config.NotificationConfig;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "io.sewah.amqp",
                "io.sewah.notificaton"
        }
)
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args){
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    ApplicationRunner applicationRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfig notificationConfig
//    ){
//       return args->{
//            producer.publish(
//                    "testttt",
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKeys()
//            );
//        };
//    }
}
