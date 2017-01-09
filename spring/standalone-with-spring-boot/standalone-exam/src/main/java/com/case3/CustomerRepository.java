package com.case3;

import org.springframework.data.jpa.repository.JpaRepository;

/**
* JPA설정
*/
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
