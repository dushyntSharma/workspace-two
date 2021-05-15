package com.mindtree.com.FilesCapability.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mindtree.com.FilesCapability.model.Employee;
import com.mindtree.com.FilesCapability.services.GetCSVReader;

public class EmployeeDaoImpl {
	private static String JDBCURL = "jdbc:mysql://127.0.0.1:3306/FileCapability";
	private static String USERNAME = "root";
	private static String PASSWORD = "9909";

	public static void csvInsertion() throws IOException {
		Connection con = null;
		PreparedStatement st = null;

		String sql = "insert into filecsv(name,company,place) values(?,?,?);";
		List<Employee> emp = new ArrayList<Employee>();
		emp = GetCSVReader.getCSVReader();
		Iterator<Employee> it = emp.iterator();
		try {
			con = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
			st = con.prepareStatement(sql);
			while (it.hasNext()) {
				Employee obj = it.next();
				st.setString(1, obj.getName());
				st.setString(2, obj.getCompany());
				st.setString(3, obj.getPlace());
				st.executeUpdate();

			}
			System.out.println("==================================");
			System.out.println("data has been successfully inserted");
			System.out.println("==================================");

			System.out.println(emp.toString());

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

	}

}
