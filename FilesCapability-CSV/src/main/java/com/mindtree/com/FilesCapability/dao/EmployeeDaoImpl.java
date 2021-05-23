package com.mindtree.com.FilesCapability.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mindtree.com.FilesCapability.model.Employee;
import com.mindtree.com.FilesCapability.services.GetCSVReader;
import com.opencsv.CSVWriter;

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
		//close the resources
		finally {
			try {
				st.close();
				con.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

	}

	public static void writeToCSV() throws SQLException, IOException {
		// Getting the connection

		Connection con = null;

		con = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
		String sql = "select * from filecsv;";
		System.out.println("Connection established......");
		// Creating the Statement
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(sql);
		// Instantiating the CSVWriter class
		CSVWriter writer = new CSVWriter(new FileWriter("output.csv"));
		ResultSetMetaData Mdata = rs.getMetaData();
		Mdata.getColumnName(1);
		// Writing data to a csv file
		String line1[] = { Mdata.getColumnName(1), Mdata.getColumnName(2), Mdata.getColumnName(3) };
		writer.writeNext(line1);
		String data[] = new String[5];
		while (rs.next()) {
			data[0] = rs.getString("Name");
			data[1] = rs.getString("Company");
			data[2] = rs.getString("Place");

			writer.writeNext(data);
		}
		// Flushing data from writer to file
		writer.flush();
		System.out.println("Data Entered to the CSV File");
	}

}
