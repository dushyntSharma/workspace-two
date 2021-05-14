package fileSystems;

import java.io.*;
import java.util.ArrayList;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private int birthYear;

	public Person(String firtName, String lastName, int birthYear) {
		this.firstName = firtName;
		this.lastName = lastName;
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return "Person{" + "firtName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", birthYear="
				+ birthYear + "}\n";
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Person p1 = new Person("Jony", "Deep", 1980);
		Person p2 = new Person("Andrew", "Justin", 1990);
		Person p3 = new Person("Valak", "Susan", 1995);

		ArrayList<Person> people = new ArrayList<>();

		people.add(p1);
		people.add(p2);
		people.add(p3);

		// write to file
		try {
			FileOutputStream writeData = new FileOutputStream("peopledata.txt");
			ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

			writeStream.writeObject(people);
	
			writeStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileInputStream readData = new FileInputStream("peopledata.txt");
			ObjectInputStream readStream = new ObjectInputStream(readData);

			ArrayList<Person> people2 = (ArrayList<Person>) readStream.readObject();
			readStream.close();

			System.out.println(people2.toString());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}