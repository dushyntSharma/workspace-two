package com.bank.model;

import java.util.Arrays;

public class Bank {
	private long bankId;
	private String bName;
	private long accId;
	private Customer[] Customer;

	public Bank() {
		super();
	}

	public Bank(long bankId, String name, long accId, com.bank.model.Customer[] customer) {
		super();
		this.bankId = bankId;
		this.bName = name;
		this.accId = accId;
		Customer = customer;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", name=" + bName + ", accId=" + accId + ", Customer="
				+ Arrays.toString(Customer) + "]";
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getName() {
		return bName;
	}

	public void setName(String name) {
		this.bName = name;
	}

	public long getAccId() {
		return accId;
	}

	public void setAccId(long accId) {
		this.accId = accId;
	}

	public Customer[] getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer[] customer) {
		Customer = customer;
	}

}
