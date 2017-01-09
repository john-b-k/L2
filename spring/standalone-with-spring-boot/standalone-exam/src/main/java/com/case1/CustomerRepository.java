package com.case1;

import com.case1.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* JPA설정
*/
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
