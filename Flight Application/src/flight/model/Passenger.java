package flight.model;

public class Passenger implements Comparable<Passenger> {
	private String firstName;
	private String lastName;
	private byte age;
	private String gender;

	public Passenger(String firstName, String lastName, byte age, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public Passenger() {
		super();

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ "]";
	}

	@Override
	public int compareTo(Passenger psgr) {
		if (this.age == psgr.age)
			return 0;
		else if (this.age > psgr.age)
			return 1;
		else
			return -1;
	}

}
