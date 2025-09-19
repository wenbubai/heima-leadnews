package com.heima.behavior;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BehaviorApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(BehaviorApplication.class, args);
    }
}
