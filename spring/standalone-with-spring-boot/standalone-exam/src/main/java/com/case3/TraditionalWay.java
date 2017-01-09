package com.case3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * Created by naver on 2017. 1. 9..
 */

//전통적인 방법
@SpringBootApplication
public class TraditionalWay {

    public static void main(String[] args) throws Exception {

        //run을 실행하면 ApplicationContext(Spring Container) 리턴한다
        //app 종료 전까지 살아있음.

        //try-with-resource 문을 사용해  AutoClosable (close())  수행되도록 강제함.
        //여기에는 AutoClosable 타입 객체들이 들어 갈 수 있음.

        //특히 ApplcationContext 얘들 중에 자신이 Hooking을 이용해 프로그램 종료될때 close() 실행하는 얘들이 있다.
        //그런 hooking 안하는 애들중 이렇게 안하면 main메서도 끝나는 데도 계속 실행 될 수 있음. tomcat을 가지고 standalone test 할때...
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(TraditionalWay.class, args);) {


            CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

            //이 Test는 Spring Container '밖'에서 수행됨
            processDbTestWithJpa(customerRepository);
        }


        //try-with-resource 테스트 with Closable
        try (AutoCloseable closeable = () -> {System.out.println("AutoClosable.close 수행, 모든 try작업수행되고 마지막에 수행될 애들을 여기다 정의하면됨.");} ){


        }

    }

    private static void processDbTestWithJpa(CustomerRepository customerRepository) {
        //Data를 H2에 insert
        customerRepository.save(new Customer("good"));
        customerRepository.save(new Customer("bad"));

        //insert 확인
        //customerRepository.findAll().forEach(c -> System.out.print(c));
        customerRepository.findAll().forEach(System.out::println);
    }
}
