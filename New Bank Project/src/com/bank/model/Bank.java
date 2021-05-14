package com.bank.model;

import java.util.List;

public class Bank {
	private int bankId;
	private String address;
	private String bName;
	private List<Customer> customer;

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(int bankId, String address, String bName, List<Customer> customer) {
		super();
		this.bankId = bankId;
		this.address = address;
		this.bName = bName;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", address=" + address + ", bName=" + bName + ", customer=" + customer + "]";
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

}
