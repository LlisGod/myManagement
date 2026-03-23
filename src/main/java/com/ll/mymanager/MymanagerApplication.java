package com.ll.mymanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ll.mymanager.mapper")
public class MymanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MymanagerApplication.class, args);
	}

}
