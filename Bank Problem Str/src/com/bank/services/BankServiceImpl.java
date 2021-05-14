package com.bank.services;

import java.util.ArrayList;

import com.bank.dao.BankDao;
import com.bank.dao.BankDaoImpl;
import com.bank.model.Bank;

public class BankServiceImpl implements BankService {
	static BankDao dao = new BankDaoImpl();
	static ArrayList<Bank> bnk = new ArrayList<Bank>();

	@Override
	public String addBankDetails(Bank b) {
		// TODO Auto-generated method stub
		bnk.add(b);
		String s = dao.addBankDetails(bnk);
		return s;
	}

}
