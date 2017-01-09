package com.case2;

import com.case1.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by naver on 2017. 1. 9..
 */

//Spring Boot 아니라 Spring Core만 이용해서 StandAlone 구현하는 방법
@SpringBootApplication
public class UsingIntializingBean {

    public static void main(String[] args) {

        //run 실행하면서 spring boot은 bean등록, 연결 등 스프링 컨테이너를 올린다.
        SpringApplication.run(UsingIntializingBean.class, args);
        System.out.println("hi hello");
    }

    @Autowired
    CustomerRepository customerRepository;

    // InitializingBean : 컨테이너가 모든 Bean Object들 을 만들고 초기화 모두 끝내면, IntializingBean 타입 객체의 메서드를 호출
    @Bean
    public InitializingBean init() {

        //InitializingBean 타입의 구현체를 Spring Bean으로 등록  ( void afterPropertiesSet() )   파리미터 전달은 안된다..
        return () -> {
            //Data를 H2에 insert
            customerRepository.save(new Customer("korea"));
            customerRepository.save(new Customer("china"));

            //insert 확인
            //customerRepository.findAll().forEach(c -> System.out.print(c));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
