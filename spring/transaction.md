# Spring Transaction 관리

#### - 용어 정리
  1. 트랜젝션 리소스 : 트랜젝션 대상이 되는 리소스(ex. 데이터 베이스)
  2. Local Transaction : 단일 Transaction에서 관리해야하는 리소스가 1개
    (ex. 1트랜젝션에서 2개 테이블 수정해야하는경우 - 트랜젝션 리소스는 DB 뿐.)
  3. Global(Distributed) Transaction : 단일 Transaction에서 관리해야하는 리소스가 2개 이상
    (ex. 1트랜젝션에서 JMS메세지 메시징 미들웨어로 전송 + DB 업데이트)
    (ex. 1트랜젝션에서 MQ와 DB를 모두 관리해야할때)
    JTA 가 필요함.


#### - 방식
  1. 선언적방식(Declartive)
  2. Programatic 방식


#### - 스프링에서 제공하는 트랜젝션 관리자.(인터페이스 / 구현체)
  [!alt tag](../txMaganers.jpg?raw=true)
