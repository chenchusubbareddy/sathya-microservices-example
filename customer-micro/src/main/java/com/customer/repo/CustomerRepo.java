package com.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.customer.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	@Query(value = "Select count(*) from Customer where phone_number = ? and password=?",nativeQuery =true)
	int checkLogin(String phoneNumber,String password);
}
