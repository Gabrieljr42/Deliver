package com.deadManWalking.DeliverApp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.deadManWalking.DeliverApp")
@EntityScan("com.deadManWalking.DeliverApp.Model")
@EnableJpaRepositories("com.deadManWalking.DeliverApp.Repository")
@ComponentScan("com.deadManWalking.DeliverApp")
public class DeliverAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliverAppApplication.class, args);
    }
}
