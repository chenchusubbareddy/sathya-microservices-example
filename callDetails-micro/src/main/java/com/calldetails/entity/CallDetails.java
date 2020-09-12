package com.calldetails.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CallDetails {

	@Id
	private Long calledId;
	private Long calledTo;
	private Long calledBy;
	@Temporal(TemporalType.DATE)
	private Date calledOn;
	private Long durationInSeconds;

	public Long getCalledId() {
		return calledId;
	}

	public void setCalledId(Long calledId) {
		this.calledId = calledId;
	}

	public Long getCalledTo() {
		return calledTo;
	}

	public void setCalledTo(Long calledTo) {
		this.calledTo = calledTo;
	}

	public Long getCalledBy() {
		return calledBy;
	}

	public void setCalledBy(Long calledBy) {
		this.calledBy = calledBy;
	}

	public Date getCalledon() {
		return calledOn;
	}

	public void setCalledon(Date calledon) {
		this.calledOn = calledon;
	}

	public Long getDurationInSeconds() {
		return durationInSeconds;
	}

	public void setDurationInSeconds(Long durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

	public CallDetails(Long calledId, Long calledTo, Long calledBy, Date calledon, Long durationInSeconds) {
		super();
		this.calledId = calledId;
		this.calledTo = calledTo;
		this.calledBy = calledBy;
		this.calledOn = calledon;
		this.durationInSeconds = durationInSeconds;
	}

	public CallDetails() {
	}

}
