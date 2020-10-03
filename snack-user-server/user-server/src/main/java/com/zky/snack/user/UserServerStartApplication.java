package com.zky.snack.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.zky.snack.user.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class UserServerStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServerStartApplication.class, args);
	}

}
