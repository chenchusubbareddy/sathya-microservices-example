package com.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Component
public class CirCuitBreakerBean {

	// private static String
	// FRIEND_URL="http://localhost:4242/FriendApi/{phoneNumber}";
	private static String FRIEND_URL = "http://custribbon/FriendApi/{phoneNumber}";

	@Autowired
	@Qualifier("restTemplateLB")
	private RestTemplate restTemplate_lb;

	@HystrixCommand(fallbackMethod = "getFriendContactsFallback")
	public List<Long> getFriendContacts(Long phoneNumber) {
		ParameterizedTypeReference<List<Long>> type = new ParameterizedTypeReference<List<Long>>() {
		};

		ResponseEntity<List<Long>> responseEntity = restTemplate_lb.exchange(FRIEND_URL, HttpMethod.GET, null, type,
				phoneNumber);
		List<Long> friendContactList = responseEntity.getBody();
		return friendContactList;
	}
	
	public List<Long> getFriendContactsFallback(Long phoneNumber) {
		return new ArrayList<Long>();
	}
}