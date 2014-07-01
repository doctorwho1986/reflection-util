package com.doctorwho.com.refection.domain;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * project_name :reflection-util
 *  @author doctorWho
 * create time :2014-6-30 上午9:31:13
 * 
 */
public class BetGroupPlan extends BetPlan {
	private String title;

	private String introduce;

	private BigDecimal perAmount = BigDecimal.ONE;

	private int part;

	private int soldPart;

	private int reservePart;
	private Calendar joinEndTime;


	private boolean isFollow;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public BigDecimal getPerAmount() {
		return perAmount;
	}


	public void setPerAmount(BigDecimal perAmount) {
		this.perAmount = perAmount;
	}


	public int getPart() {
		return part;
	}


	public void setPart(int part) {
		this.part = part;
	}


	public int getSoldPart() {
		return soldPart;
	}


	public void setSoldPart(int soldPart) {
		this.soldPart = soldPart;
	}


	public int getReservePart() {
		return reservePart;
	}


	public void setReservePart(int reservePart) {
		this.reservePart = reservePart;
	}


	public Calendar getJoinEndTime() {
		return joinEndTime;
	}


	public void setJoinEndTime(Calendar joinEndTime) {
		this.joinEndTime = joinEndTime;
	}


	public boolean isFollow() {
		return isFollow;
	}


	public void setFollow(boolean isFollow) {
		this.isFollow = isFollow;
	}
	
	







}
