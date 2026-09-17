package com.spring_boot_mybatis_ex.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring_boot_mybatis_ex.project"})
@MapperScan(basePackages = {"com.spring_boot_mybatis_ex.project"})
public class SpringBootMybatisExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisExApplication.class, args);
	}

}
