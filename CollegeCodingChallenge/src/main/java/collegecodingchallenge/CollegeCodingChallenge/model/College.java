package collegecodingchallenge.CollegeCodingChallenge.model;

import java.util.List;

public class College {

	private int cid;
	private String name;
	private int strength;
	private List<Student> student;

	public College(int cid, String name, int strength, List<Student> student) {
		super();
		this.cid = cid;
		this.name = name;
		this.strength = strength;
		this.student = student;
	}

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "College [cid=" + cid + ", name=" + name + ", strength=" + strength + ", student=" + student + "]";
	}

}
