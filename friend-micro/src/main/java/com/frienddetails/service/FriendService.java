package com.frienddetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frienddetails.entity.Friend;
import com.frienddetails.repo.FriendRepo;

@Service
public class FriendService {

	@Autowired
	FriendRepo friendRepo;

	public String addFriendService(Friend friend) {
		Integer count = friendRepo.checkFriendContact(friend.getPhoneNumber(), friend.getFriendNumber());
		if (count == 0) {
			friendRepo.saveAndFlush(friend);
			return "Friend Contact is added";
		} else {
			return "Friend  Contact already exist";
		}
	}
	
	public List<Long> readFriendContacts(Long phoneNumber){
		return friendRepo.findFriendsContactNumbers(phoneNumber);	
	}
}
