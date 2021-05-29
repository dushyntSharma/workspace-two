package codingchallenge.CodingChallenge.client;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import codingchallenge.CodingChallenge.exceptions.ExceedingStrengthOfStudents;
import codingchallenge.CodingChallenge.model.College;
import codingchallenge.CodingChallenge.model.Student;
import codingchallenge.CodingChallenge.service.CollegeService;
import codingchallenge.CodingChallenge.service.CollegeServiceImpl;

public class CollegeApp {
	static Scanner sc = new Scanner(System.in);
	static CollegeService service = new CollegeServiceImpl();

	public static void main(String[] args) throws FileNotFoundException, ExceedingStrengthOfStudents {
		boolean flag = true;
		int choice = 0;
		do {
			displayMenu();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				String s = null;
				;
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
				FileWriter writer;
				try {
					writer = new FileWriter(
							"C:\\Users\\SHREEVATSA\\Desktop\\Eclipse Workplace - 1\\CodingChallenge\\src\\main\\java\\codingchallenge\\CodingChallenge\\college.txt");
					for (College c1 : clg) {

						writer.write(c1 + System.lineSeparator());
					}
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("==========================================");

//				clg.stream().filter(t -> t.getCid() < 5).forEach(t -> System.out.println(t));
				break;

			case 3:
				TreeSet<String> sd = service.displayStudentsByAge();
				System.out.println(sd.toString());
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

		System.out.println();

	}

}
