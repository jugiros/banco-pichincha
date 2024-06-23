package com.example.banco_pichincha.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {
    @RabbitListener(queues = "cuentaQueue")
    public void listen(String message) {
        System.out.println(message);
    }
}
