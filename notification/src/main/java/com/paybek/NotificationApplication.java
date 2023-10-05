package com.paybek;

import com.paybek.amqp.RabbitMQMessageProducer;
import com.paybek.notification.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

// Bahodir Hasanov 9/22/2022 6:30 PM
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {
        "com.paybek.notification",
        "com.paybek.amqp"
})
public class  NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            RabbitMQMessageProducer producer,
            NotificationConfig notificationConfig
    ) {
        return args -> {
            producer.publish(
                    new Person("Ali", 26),
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey()
            );
        };
    }

    record Person(String name, int age) {
    }
}
