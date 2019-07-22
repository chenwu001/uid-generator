package com.kj.uid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan({ "com.kj.uid.worker.dao" })
@ComponentScan(basePackages = {"com.kj"})
@EnableFeignClients(basePackages = {"com.kj"})
public class UidGeneratorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UidGeneratorApplication.class, args);
	}
	
}
