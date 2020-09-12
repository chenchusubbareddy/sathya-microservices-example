package com.customer.dto;

import java.util.List;

public class CustomerDto {

private Long phoneNumber;
	
	private String userName;
	
	
	private String email;
	
	private String planId;
	
	
	private PlanDTO currentPlan;
	
	private List<Long> friendsContactNumbers;

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public PlanDTO getCurrentPlan() {
		return currentPlan;
	}

	public void setCurrentPlan(PlanDTO currentPlan) {
		this.currentPlan = currentPlan;
	}

	public List<Long> getFriendsContactNumbers() {
		return friendsContactNumbers;
	}

	public void setFriendsContactNumbers(List<Long> friendsContactNumbers) {
		this.friendsContactNumbers = friendsContactNumbers;
	}
	
	
}
