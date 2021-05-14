package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.bank.model.Bank;
import com.bank.model.Customer;
import com.bank.utility.DBConnection;

public class BankDaoImpl implements BankDao {

	@Override
	public String addBankDetails(ArrayList<Bank> bnk) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String s = null;
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		Bank bank = bnk.get(0);
		System.out.println(bank.toString());
		String sql = "insert into bank values(?,?,?);";
		try {
			st = con.prepareStatement(sql);
			st.setLong(1, bank.getBankId());
			st.setString(2, bank.getName());
			st.setLong(3, bank.getAccId());
			st.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Customer[] c = bank.getCustomer();
		String query = "Insert into customer values(?,?,?);";
		for (int i = 0; i < c.length; i++) {
			try {
				st = con.prepareStatement(query);
				st.setLong(1, bank.getAccId());
				st.setString(2, c[i].getName());
				st.setString(3, c[i].getBranch());
				st.executeUpdate();
				flag = true;
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		if (flag == true)
			s = "Added Successfully";

		return s;
	}

}
