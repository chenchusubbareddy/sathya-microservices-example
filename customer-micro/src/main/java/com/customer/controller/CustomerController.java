package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.dto.CustomerDto;
import com.customer.dto.LoginDTO;
import com.customer.dto.PlanDTO;
import com.customer.dto.RegisterDTO;
import com.customer.feign.FriendFeign;
import com.customer.feign.PlanFeign;
import com.customer.service.CirCuitBreakerBean;
import com.customer.service.CustomerService;

@RestController
///@RibbonClient(name="custribbon")
public class CustomerController {

	private static String PLAN_URL="http://localhost:4343/PlanApi/{planId}";
	//private static String FRIEND_URL="http://localhost:4242/FriendApi/{phoneNumber}";
	private static String FRIEND_URL="http://custribbon/FriendApi/{phoneNumber}";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	@Qualifier("restTemplateLB")
	private RestTemplate restTemplate_lb;
	
	@Autowired
	CustomerService customerService;
	@Autowired
	CirCuitBreakerBean cirCuitBreakerBean;
	
	@Autowired
	private PlanFeign planFeign;
	
	@Autowired
	private FriendFeign friendFeign;
	
	
	@PostMapping("/register")
	public boolean addCustomer(@RequestBody RegisterDTO registerDto) {
		return customerService.registerCustomer(registerDto);
	}
	
	@GetMapping("/login")
	public boolean loginCustomer(@RequestBody LoginDTO logindto) {
		return customerService.loginCustomer(logindto);
		
	}
	
	@GetMapping("/viewProfile/{phoneNumber}")
	public CustomerDto customerProfile(@PathVariable Long phoneNumber) {
		CustomerDto customerDto = customerService.readCustomer(phoneNumber);
		// call friend micro
		//List<Long> friendContactList = cirCuitBreakerBean.getFriendContacts(customerDto.getPhoneNumber());
		List<Long> friendContactList =	friendFeign.getFriends(customerDto.getPhoneNumber());
		customerDto.setFriendsContactNumbers(friendContactList);
		
		//calling pan micro
		//PlanDTO plandto = restTemplate.getForObject(PLAN_URL,PlanDTO.class,customerDto.getPlanId());
		PlanDTO plandto=planFeign.getPlanDetails(customerDto.getPlanId());
		customerDto.setCurrentPlan(plandto);
		return customerDto;
	}
}
