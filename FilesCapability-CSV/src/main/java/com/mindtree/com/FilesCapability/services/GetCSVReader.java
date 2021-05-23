package com.mindtree.com.FilesCapability.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.com.FilesCapability.model.Employee;

public class GetCSVReader {
	public static List<Employee> getCSVReader() throws IOException {

		List<Employee> emp = new ArrayList<>();
		String fileIn = "C:/Users/SHREEVATSA\\Desktop/Eclipse Workplace - 1/FilesCapability/csvFileCaps.csv";

		String line = null;

		// Read all lines in from CSV file and add to studentList
		FileReader fileReader = new FileReader(fileIn);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		try {
			while ((line = bufferedReader.readLine()) != null) {
				String[] temp = line.split(",");
				String name = temp[0];
				String company = temp[1];
				String place = temp[2];
				emp.add(new Employee(name, company, place));
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedReader.close();
		return emp;
	}

}
