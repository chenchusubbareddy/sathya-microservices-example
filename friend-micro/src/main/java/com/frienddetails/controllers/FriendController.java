package com.frienddetails.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frienddetails.entity.Friend;
import com.frienddetails.service.FriendService;

@RestController
public class FriendController {

	@Autowired
	FriendService friendService; 
	
	@PostMapping("/addFriend")
	public String  addFriend(@RequestBody Friend friend) {
		return  friendService.addFriendService(friend);
	}
	
	@GetMapping("/{phoneNumber}")
	public List<Long> getFriendsContacts(@PathVariable Long phoneNumber){
		return friendService.readFriendContacts(phoneNumber);
	}
}
