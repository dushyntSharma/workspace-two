package CSVreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsingBufferedReader {
	public static void main(String[] args) throws IOException {

		List<Employee> studentList = new ArrayList<>();
		String fileIn = "C:\\Users\\SHREEVATSA\\Desktop\\Eclipse Workplace - 1\\File Capability\\csvBuffered.txt";

		String line = null;

		// Read all lines in from CSV file and add to studentList
		FileReader fileReader = new FileReader(fileIn);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		try {
			while ((line = bufferedReader.readLine()) != null) {
				String[] temp = line.split(",");
				String name = temp[0];
				int age = Integer.parseInt(temp[1]);
				String company = temp[2];
				int salary = Integer.parseInt(temp[3]);
				studentList.add(new Employee(name, age, company, salary));
			}
			System.out.println(studentList);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedReader.close();
	}
}
