package com.case1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

//Another Version : @SpringBootApplication도 @Configuration 형식이니까 Spring Bean이므로
//CommandLineRunner 직접 implements 할 수 있다 (CommandLineRunner 구현한 class 중 Spring Bean 등록된 것들의 run()실행됨)

@SpringBootApplication
public class UsingCommandLineRunnerV2 implements CommandLineRunner {
    public static void main(String[] args) {

        //run 실행하면서 spring boot은 bean등록, 연결 등 스프링 컨테이너를 올린다.
        SpringApplication.run(UsingCommandLineRunnerV2.class, args);
        System.out.println("hi");
    }

    @Autowired
    CustomerRepository customerRepository;



    //Spring Boot에서 제공한 CommandLineRunner Interface를 구현한 Object의 run()메서드를 호출한다
    //UsingCommandLineRunnerV2 는 CommandLineRunner구현 해야 함
    @Override
    public void run(String... args) throws Exception {
        //Data를 H2에 insert
        customerRepository.save(new Customer("kim"));
        customerRepository.save(new Customer("lee"));

        //insert 확인
        //customerRepository.findAll().forEach(c -> System.out.print(c));
        customerRepository.findAll().forEach(System.out::println);
    }



    //CommandLineRunner구현하는 또 다른 빈빈
    //Spring Bean 이 되었고, CommandLineRunner를 구현하므로 Container가 Runner메서드 호춢
    @Component
    public static class MyRunner implements CommandLineRunner {

        @Autowired
        CustomerRepository customerRepository;

        @Override
        public void run(String... args) throws Exception {
            //Data를 H2에 insert
            customerRepository.save(new Customer("boy"));
            customerRepository.save(new Customer("girl"));

            //insert 확인
            //customerRepository.findAll().forEach(c -> System.out.print(c));
            customerRepository.findAll().forEach(System.out::println);
        }
    }
}

