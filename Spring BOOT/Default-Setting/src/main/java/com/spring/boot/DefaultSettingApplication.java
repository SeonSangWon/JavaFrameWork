package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DefaultSettingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DefaultSettingApplication.class, args);
	}

	// Spring Boot를 war 파일로 배포
	// SpringBootServletInitializer 를 상속받고 , configure()를 override
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
		
		return builder.sources(DefaultSettingApplication.class); 
	}

}
