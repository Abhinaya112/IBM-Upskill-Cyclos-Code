package com.training.bean;

public class ContactPayBean {
	private String name;
	private String amount;
	private String description;

	public ContactPayBean() {
	}

	public ContactPayBean(String name, String amount,String description) {
		super();
		this.name = name;
		this.amount = amount;
		this.description=description;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	

	public String getamount() {
		return amount;
	}

	public void setamount(String amount) {
		this.amount = amount;
	}


	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "ContactPayBean [name=" + name + ", amount=" + amount + ",description=" + description + "]";
	}

}

