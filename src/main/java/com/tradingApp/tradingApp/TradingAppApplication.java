package com.tradingApp.tradingApp;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


@SpringBootApplication
@AllArgsConstructor
@Service
public class TradingAppApplication {


	public static void main(String[] args){
		System.out.println("TradingApp Application Started");
		System.out.println("Test123123");
		SpringApplication.run(TradingAppApplication.class, args);
	}
}