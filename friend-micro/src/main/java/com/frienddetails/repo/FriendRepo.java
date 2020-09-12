package com.frienddetails.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.frienddetails.entity.Friend;

public interface FriendRepo extends JpaRepository<Friend, Integer> {
	
	@Query(value="select count(*) from friend where phone_no=? and friend_n=?",nativeQuery = true)
	Integer checkFriendContact(Long phoneNumber,Long friendNumber);
	@Query(value="select fried_no from friend where phone_no=? ",nativeQuery = true)
	List<Long> findFriendsContactNumbers(Long phoneNumber);

}
