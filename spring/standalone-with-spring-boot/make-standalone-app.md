#### Spring Boot를 이용해 standalone app 만들기

1. Spring Boot로 Web App만 만들 수 있는게 아니다. jar 실행으로 스프링 앱 실행
2. StandAlone 형식으로 간단히 DB Test 등 같으 심플 테스트도 할 수 있다.
3. 3가지 방법이 있다.  
    - CommandLineRunner 구현한 객체 Bena 등록 (자동적으로 run(args)  실행)
    - InitializingBean 구현한 객체 Bean 등록 (자동적으로 afterPropertiesSet 실행)
    -  Bean 등록 후 get 해서 Bean 메서드 실행하는 전통적 getBean 방식

4. 추가적으로 try-with-resource 문
```
//try(AutoClosable 구현 객체 위치함)
try(AutoClosable ac = () -> { //마지막에 실행할 코드}){

}

```
