package com.training.bean;



public class MemberPayBean {

	private String memberUsername;
	private String amount;
	private String transactionType;
	private String description;

	public MemberPayBean() {
	}

	public MemberPayBean(String memberUsername, String amount, String transactionType,String description) {
		super();
		this.memberUsername = memberUsername;
		this.amount = amount;
		this.transactionType=transactionType;
		this.description=description;
	}

	public String getmemberUsername() {
		return memberUsername;
	}

	public void setmemberUsername(String memberUsername) {
		this.memberUsername = memberUsername;
	}
	

	public String getamount() {
		return amount;
	}

	public void setamount(String amount) {
		this.amount = amount;
	}

	public String gettransactionType() {
		return transactionType;
	}

	public void settransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "MemberPayBean [memberUsername=" + memberUsername + ", amount=" + amount + ",transactionType=" + transactionType+ ",description=" + description + "]";
	}

}
