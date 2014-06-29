package com.doctorwho.com.refection.domain;

import java.math.BigDecimal;


public class BetPlan {
	private Long id;
	/** 方案编号 */
	private String planNo;

	/** 用户ID */
	private Long memberId;

	/** 用户帐号 */
	private String account;
	
	/** 彩期编号 */
	private String issueNo;

	/** 方案总金额 */
	private BigDecimal amount;

	/** 方案倍数 */
	private int multiple;

	/** 方案总注数 */
	private int betCount;
	
	private BetOrder order;

	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlanNo() {
		return planNo;
	}

	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getIssueNo() {
		return issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}

	public int getBetCount() {
		return betCount;
	}

	public void setBetCount(int betCount) {
		this.betCount = betCount;
	}

	public BetOrder getOrder() {
		return order;
	}

	public void setOrder(BetOrder order) {
		this.order = order;
	}
	
	public void setOrder(Long orderId) {
		this.order = new BetOrder();
		this.order.setId(orderId);
	}
	
	public void setOrder(long orderId) {
		this.order = new BetOrder();
		this.order.setId(orderId);
	}
	
	public void setOrderId(Long orderId) {
		this.order = new BetOrder();
		this.order.setId(orderId);
	}
}
