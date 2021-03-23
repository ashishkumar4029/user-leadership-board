package com.leadership.user.rank.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

//@Controller
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "com.leadership")
public class LeadershipBoardConfig {
	public static void main(String[] args) {
		SpringApplication.run(LeadershipBoardConfig.class, args);
	}
}
