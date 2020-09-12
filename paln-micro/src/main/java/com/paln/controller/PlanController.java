package com.paln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.paln.entity.Plan;
import com.paln.service.PlanService;

@RestController
public class PlanController {
	
	@Autowired
	PlanService planService;
	
	@GetMapping("/browsePlans")
	public List<Plan> getPlans(){
		return planService.getAllPlans();
	}
	
	@GetMapping("/{planId}")
	public Plan getSpecificPlan(@PathVariable String planId) {
		return planService.getSpecificPlan(planId);
	}
}
