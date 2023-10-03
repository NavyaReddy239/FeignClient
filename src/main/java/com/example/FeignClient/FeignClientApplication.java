package com.example.FeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.FeignClient.retreival.PersonDetailRetreival;
@EnableFeignClients
@SpringBootApplication
public class FeignClientApplication {
	public static void main(String[] args) {
	SpringApplication.run(FeignClientApplication.class, args);
	}
	
}
