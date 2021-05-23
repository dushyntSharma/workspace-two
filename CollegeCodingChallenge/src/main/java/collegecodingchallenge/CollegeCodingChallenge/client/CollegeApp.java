package collegecodingchallenge.CollegeCodingChallenge.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import collegecodingchallenge.CollegeCodingChallenge.exceptions.ConnectionFailedException;
import collegecodingchallenge.CollegeCodingChallenge.exceptions.ExceedingStrengthOfStudents;
import collegecodingchallenge.CollegeCodingChallenge.exceptions.NoSuchCollegeException;
import collegecodingchallenge.CollegeCodingChallenge.model.College;
import collegecodingchallenge.CollegeCodingChallenge.model.Student;
import collegecodingchallenge.CollegeCodingChallenge.service.CollegeService;
import collegecodingchallenge.CollegeCodingChallenge.service.CollegeServiceImpl;

public class CollegeApp {
	static Scanner sc = new Scanner(System.in);
	static CollegeService service = new CollegeServiceImpl();

	public static void main(String[] args)
			throws ExceedingStrengthOfStudents, ConnectionFailedException, NoSuchCollegeException, IOException {
		boolean flag = true;
		int choice = 0;
		do {
			displayMenu();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				String s = null;

				try {
					s = addCollegeDetails();

				} catch (ExceedingStrengthOfStudents e) {
					// TODO Auto-generated catch block
					throw new ExceedingStrengthOfStudents("College strength is exceeding");
				}
				System.out.println(s);
				break;

			case 2:
				List<College> clg = service.displayCollegeDetails();

				// I'm writing this displayed data in the text file....
				FileWriter writer;
				try {
					writer = new FileWriter("college.txt");
					for (College c1 : clg) {

						writer.write(c1 + System.lineSeparator());
					}
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// csv file reading
				FileWriter csvWriter = new FileWriter("new.csv");

				for (College rowData : clg) {
					csvWriter.write(rowData + ",");
					csvWriter.append("\n");
				}

				csvWriter.flush();
				csvWriter.close();

				// chaining of streams
				File f = new File("Output.txt");
				FileOutputStream fos = new FileOutputStream(f);
				OutputStreamWriter out = new OutputStreamWriter(fos);
				for (College c1 : clg) {

					out.write(c1 + System.lineSeparator());
				}
				out.close();

				System.out.println("==========================================");

				// displaying using the filter...
				System.out.println(clg.toString());
				// clg.stream().filter(t -> t.getCid() < 10).forEach(t ->
				// System.out.println(t));
				break;

			case 3:
				try {
					HashMap<String, String> sd = service.displayStudentsByAge();
				} catch (NoSuchCollegeException e) {
					// TODO Auto-generated catch block
					throw new NoSuchCollegeException("No college found");
				}

				break;
			case 4:
				service.displayCollegeName();
				break;

			default:
				System.out.println("Invalid choice!!");
				break;
			}

		} while (flag);
	}

	private static String addCollegeDetails() throws ExceedingStrengthOfStudents {
		// TODO Auto-generated method stub
		boolean flag = true;
		List<College> college = new ArrayList<College>();
		System.out.println("Enter the College ID");
		int cid = sc.nextInt();
		System.out.println("Enter the college name");
		String name = sc.next();
		System.out.println("Enter the strength of the college");
		sc.nextLine();
		int strength = sc.nextInt();
		System.out.println("Enter the students?");
		int n = sc.nextInt();
		try {
			if (n > strength) {
				flag = false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new ExceedingStrengthOfStudents("College strength is exceeding");
		}
		List<Student> student = new ArrayList<Student>(n);
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the student Id");
			int sid = sc.nextInt();
			System.out.println("ENter the student name");
			String sname = sc.next();
			System.out.println("Enter the age");
			short age = sc.nextShort();
			System.out.println("Enter the subject");
			String subject = sc.next();
			Student s = new Student(sid, sname, age, subject, cid);

			student.add(s);
		}
		College c = new College(cid, name, strength, student);
		college.add(c);

		String s = service.addCollegeDetails(college);

		return s;

	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("1.Add College Details");
		System.out.println("2.Display Student Details");
		System.out.println("3.Display Student By Age");
		System.out.println("4.Display using college Name");

		System.out.println();

	}

}
