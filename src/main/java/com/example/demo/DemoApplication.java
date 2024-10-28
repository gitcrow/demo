package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Droid;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		System.out.println("helloo~~");
	}

	//외부컴포넌트를 스프링빈으로 인스턴스화하는 방법 
	//		@Configuration 어노테이션이 달린 클래스 내에서(여기서는 DemoApplication, 왜냐면 @SpringBootApplication이 @Configuration을 포함하므로..)
	//		직접 또는 메타어노테이션을 통해 @Bean 어노테이션이 달린 메서드를 생성하는 방법이 적합함..
	//		때문에 주로 빈 생성 메서드를 메인 클래스에 작성함(메인에 @Configuration를 포함하는 메타어노테이션@SpringBootApplication이 달려있음)
	@Bean
	@ConfigurationProperties(prefix = "droid")
	Droid createDroid(){
		return new Droid();
	}

}

