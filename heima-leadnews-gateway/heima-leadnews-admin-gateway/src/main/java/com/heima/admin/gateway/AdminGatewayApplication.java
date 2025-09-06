package com.heima.admin.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminGatewayApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(AdminGatewayApplication.class, args);
    }
}
