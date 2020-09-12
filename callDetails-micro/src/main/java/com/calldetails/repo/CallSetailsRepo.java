package com.calldetails.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calldetails.entity.CallDetails;

public interface CallSetailsRepo extends JpaRepository<CallDetails, Long> {
  public  List<CallDetails> findByCalledBy(Long calledBy);
}
