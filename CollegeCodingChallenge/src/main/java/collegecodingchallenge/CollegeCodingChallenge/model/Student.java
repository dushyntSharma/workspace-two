package collegecodingchallenge.CollegeCodingChallenge.model;

public class Student {
	private int sid;
	private String sname;
	private short age;
	private String subject;
	private int cid;

	public Student(int sid, String sname, short age, String subject, int cid) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.subject = subject;
		this.cid = cid;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", age=" + age + ", subject=" + subject + ", cid=" + cid
				+ "]";
	}

}
