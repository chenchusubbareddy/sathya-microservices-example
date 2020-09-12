package com.customer.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dto.CustomerDto;
import com.customer.dto.LoginDTO;
import com.customer.dto.RegisterDTO;
import com.customer.entity.Customer;
import com.customer.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo repo;
	
	
	public boolean registerCustomer(RegisterDTO registerDTO) {
		if(repo.existsById(registerDTO.getPhoneNumber())==false) {
			Customer cust = new Customer();
			BeanUtils.copyProperties(registerDTO, cust);
			repo.save(cust);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean loginCustomer(LoginDTO loginDTO) {
		return repo.checkLogin(loginDTO.getPhoneNumber(),loginDTO.getPassword())==1;
	}
	
	public CustomerDto readCustomer(Long phoneNumber) {
		Customer cust= repo.findById(phoneNumber).get();
		CustomerDto cdto = new CustomerDto();
		BeanUtils.copyProperties(cust,cdto);
		return cdto;
	}
}
