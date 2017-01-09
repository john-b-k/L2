package com.case1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot를 사용해서 Standalone 으로 동작하는 스프링 프로젝트를 생성한다
 * Command Line으로 실행
 *
 */
@SpringBootApplication
public class UsingCommandLineRunnerV1 {

	public static void main(String[] args) {

		//run 실행하면서 spring boot은 bean등록, 연결 등 스프링 컨테이너를 올린다.
		SpringApplication.run(UsingCommandLineRunnerV1.class, args);
		System.out.println("hello");
	}

	//SpringApplication.run 실행하면서 injection됨
	@Autowired
	CustomerRepository customerRepository;


	//CommandLineRunner Type의 Object를 Spring Bean 으로 등록 (CommandLineRunner의 구현체를 리턴)
	//Spring Boot 컨테이너는 컨테이너가 올라간후
	//컨네이터는 Bean등 중 Spring Boot에서 제공한 CommandLineRunner Interface를 구현한 Object의 run()메서드를 호출한다
	@Bean
	public CommandLineRunner runner(){

		//run(String... args)를 람다식으로 표현현  args : CLI에서 들어온 파리미터 값들
		return (args) -> {

				//Data를 H2에 insert
				customerRepository.save(new Customer("YoonDo"));
				customerRepository.save(new Customer("Sam"));

				//insert 확인
				//customerRepository.findAll().forEach(c -> System.out.print(c));
				customerRepository.findAll().forEach(System.out::println);
		};
	}
}