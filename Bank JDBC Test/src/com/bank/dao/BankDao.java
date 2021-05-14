package com.bank.dao;

import java.util.List;

import com.bank.model.Bank;
import com.bank.model.Customer;

public interface BankDao {

	void addBankDetails(List<Bank> bank);

	void addCustomerDetails(List<Customer> customer);

}
package com.bank.dao;

import java.util.List;

import com.bank.model.Bank;

public interface BankDao {
s
	String addBankdetails(List<Bank> bank);

	List<Bank> displayBankDeatils();

	String deleteBankId(int bankId);

}
