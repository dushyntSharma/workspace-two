package com.bank.model;

public class Customer {
	private int accNo;
	private String accType;
	private String cbName;

	public Customer() {

	}

	public Customer(int accNo, String accType, String cbName) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.cbName = cbName;
	}

	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", accType=" + accType + ", cbName=" + cbName + "]";
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getCbName() {
		return cbName;
	}

	public void setCbName(String cbName) {
		this.cbName = cbName;
	}

}
