package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Customer;
import com.bank.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String addCustomer(List<Customer> customer) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String str = null;
		PreparedStatement st = null;
		String query2 = "insert into customer(accNo,accType,bName) values(?,?,?);";
		try {
			for (int i = 0; i < customer.size(); i++) {
				st = con.prepareStatement(query2);
				st.setInt(1, customer.get(i).getAccNo());
				st.setString(2, customer.get(i).getAccType());
				st.setString(3, customer.get(i).getCbName());
				st.execute();

			}
			str = "Customers added successfully";

		} catch (Exception e) {
			// TODO: handle exception
		}

		return str;
	}

	@Override
	public List<Customer> displayCustomerDetails() {
		// TODO Auto-generated method stub
		List<Customer> cus = new ArrayList<Customer>();
		Connection con = DBConnection.getConnection();
		Statement st = null;
		ResultSet res = null;
		String query = "select * from customer";
		try {
			st = con.createStatement();
			res = st.executeQuery(query);
			while (res.next()) {
				int accNo = res.getInt("accNo");
				String accType = res.getString("accType");
				String bName = res.getString("bName");
				cus.add(new Customer(accNo, accType, bName));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return cus;
	}

}
