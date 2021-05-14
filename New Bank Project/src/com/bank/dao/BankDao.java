package com.bank.dao;

import java.util.List;

import com.bank.model.Bank;

public interface BankDao {

	String addBankdetails(List<Bank> bank);

	List<Bank> displayBankDeatils();

	String deleteBankId(int bankId);

}
