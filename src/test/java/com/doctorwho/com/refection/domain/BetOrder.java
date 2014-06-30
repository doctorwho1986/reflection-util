package com.doctorwho.com.refection.domain;

import java.math.BigDecimal;
import java.util.Calendar;

public class BetOrder {
	   private Long id;

	    private String orderNo;

	    private Long memberId;

	    private String account;


	    private BigDecimal amount = BigDecimal.ZERO;

	    private Calendar createTime;

	    private Long sellChannel;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getOrderNo() {
			return orderNo;
		}

		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
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

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		public Calendar getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Calendar createTime) {
			this.createTime = createTime;
		}

		public Long getSellChannel() {
			return sellChannel;
		}

		public void setSellChannel(Long sellChannel) {
			this.sellChannel = sellChannel;
		}
}
