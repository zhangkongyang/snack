package com.zky.snack.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.zky.snack.order.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServerStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderServerStartApplication.class, args);
	}

}
