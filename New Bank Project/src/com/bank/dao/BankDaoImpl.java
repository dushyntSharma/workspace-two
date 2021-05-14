package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Bank;
import com.bank.model.Customer;
import com.bank.services.BankService;
import com.bank.services.BankServiceImpl;
import com.bank.utility.DBConnection;

public class BankDaoImpl implements BankDao {
	static BankService service = new BankServiceImpl();
	static CustomerDao cus = new CustomerDaoImpl();

	@Override
	public String addBankdetails(List<Bank> bank) {
		CustomerDao cus = new CustomerDaoImpl();
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		String str = null;
		String query = "insert into bank(bankId,address,bName) values(?,?,?);";
		Bank obj = bank.get(0);
		try {
			st = con.prepareStatement(query);
			st.setInt(1, obj.getBankId());
			st.setString(2, obj.getAddress());
			st.setString(3, obj.getbName());
			st.executeUpdate();
			String s = cus.addCustomer(obj.getCustomer());
			str = "Bank ID with '" + obj.getBankId() + "' was succesfully inserted";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public List<Bank> displayBankDeatils() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<Bank> bk = new ArrayList<Bank>();
		String query = "select * from bank;";
		Statement st = null;
		ResultSet res = null;
		try {
			st = con.createStatement();
			res = st.executeQuery(query);
			while (res.next()) {
				int bankId = res.getInt("bankId");
				String address = res.getString("address");
				String bName = res.getString("bName");
				// List<Customer> customer = cus.displayCustomerDetails();
				List<Customer> customer = null;
				bk.add(new Bank(bankId, address, bName, customer));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return bk;
	}


	@Override
	public String deleteBankId(int bankId) {
		Connection con = DBConnection.getConnection();
		Statement st = null;
		String str = null;
		String query = "Delete from bank where bankId = ?;";
		try {
			st = con.createStatement();
			st.executeUpdate(query);
			str = "Deleted Successfully...";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return str;
	}

}
