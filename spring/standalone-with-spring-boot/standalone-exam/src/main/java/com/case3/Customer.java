package com.case3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
* JPA Entity설정
*/
@Entity
public class Customer {
    @Id
    @GeneratedValue
    Long id;

    String name;

    Customer() {

    }

    public Customer(String name) {
this.name = name;
}

    @Override
    public String toString() {
return "[ "+ this.id + ", " + this.name + " ]";
}
}
