package com.paln.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paln.entity.Plan;
@Repository
public interface PlanRepository  extends JpaRepository<Plan,String>{
	
}
