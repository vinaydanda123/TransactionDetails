package com.Banking.TransactionDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class TransactionDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionDetailsApplication.class, args);
	}

}
