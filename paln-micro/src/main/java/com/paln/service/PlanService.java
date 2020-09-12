package com.paln.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paln.entity.Plan;
import com.paln.repo.PlanRepository;

@Service
public class PlanService {

	@Autowired
	PlanRepository  repo;
	
	public List<Plan> getAllPlans(){
		return repo.findAll();
	}
	
	public Plan getSpecificPlan(String planId) {
		return repo.findById(planId).get();
	}
}
