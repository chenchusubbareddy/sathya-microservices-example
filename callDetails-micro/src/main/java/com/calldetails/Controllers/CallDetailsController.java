package com.calldetails.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calldetails.entity.CallDetails;
import com.calldetails.repo.CallSetailsRepo;
@RestController
public class CallDetailsController {
	@Autowired
	private CallSetailsRepo callSetailsRepo;
	
	@RequestMapping("/{phoneNumber}")
	public List<CallDetails> getCallDetailsByPhoneNumber(@PathVariable Long phoneNumber){
		return callSetailsRepo.findByCalledBy(phoneNumber);
	}

}
