package com.bank.services;

import java.util.List;

import com.bank.model.Bank;
import com.bank.model.Customer;

public interface BankService {

	String addBankDetails(List<Bank> bank);

	List<Bank> displayBankDetails();

	List<Customer> displayCustomerDetails();

	String deleteBankId(int bankId);

}
