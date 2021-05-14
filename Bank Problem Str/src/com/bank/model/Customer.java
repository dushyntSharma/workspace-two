package com.bank.model;

public class Customer {
	private long accId;
	private String cName;
	private String branch;

	public Customer(long accId, String name, String branch) {
		super();
		this.accId = accId;
		this.cName = name;
		this.branch = branch;
	}

	public Customer() {
		super();
	}

	public long getAccId() {
		return accId;
	}

	public void setAccId(long accId) {
		this.accId = accId;
	}

	public String getName() {
		return cName;
	}

	public void setName(String name) {
		this.cName = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
