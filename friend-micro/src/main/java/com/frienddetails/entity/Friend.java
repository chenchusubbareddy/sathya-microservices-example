package com.frienddetails.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Long phoneNumber;
	private Long friendNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getFriendNumber() {
		return friendNumber;
	}

	public void setFriendNumber(Long friendNumber) {
		this.friendNumber = friendNumber;
	}

	public Friend(Integer id, Long phoneNumber, Long friendNumber) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.friendNumber = friendNumber;
	}

	public Friend() {
	}

}
