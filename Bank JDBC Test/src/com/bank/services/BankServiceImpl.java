package com.bank.services;

import java.util.ArrayList;
import java.util.List;

import com.bank.client.BankApp;
import com.bank.dao.BankDao;
import com.bank.dao.BankDaoImpl;
import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;
import com.bank.model.Bank;
import com.bank.model.Customer;

public class BankServiceImpl implements BankService {
	static BankDao dao = new BankDaoImpl();
	static CustomerDao cdao = new CustomerDaoImpl();

	@Override
	public String addBankDetails(List<Bank> bank) {
		// TODO Auto-generated method stub
		String s = null;
		try {
			s = dao.addBankDetails(bank);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Bank> displayBankDetails() {
		// TODO Auto-generated method stub
		List<Bank> bk = dao.displayBankDeatils();
		return bk;
	}

	@Override
	public List<Customer> displayCustomerDetails() {
		// TODO Auto-generated method stub
		List<Customer> cus = cdao.displayCustomerDetails();
		return cus;
	}

	@Override
	public String deleteBankId(int bankId) {
		String s = dao.deleteBankId(bankId);
		return s;
	}

}
