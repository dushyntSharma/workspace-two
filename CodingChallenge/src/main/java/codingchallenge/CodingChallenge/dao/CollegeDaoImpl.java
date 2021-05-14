package codingchallenge.CodingChallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import codingchallenge.CodingChallenge.exceptions.ConnectionFailedException;
import codingchallenge.CodingChallenge.model.College;
import codingchallenge.CodingChallenge.model.Student;
import codingchallenge.CodingChallenge.service.CollegeService;
import codingchallenge.CodingChallenge.service.CollegeServiceImpl;
import codingchallenge.CodingChallenge.utility.DBConnection;

public class CollegeDaoImpl implements CollegeDao {
	static StudentDao it = new StudentDaoImpl();
	static CollegeService service = new CollegeServiceImpl();

	@Override
	public String addCollegeDetails(List<College> college) throws ConnectionFailedException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		String str = null;
		String query = "insert into college(cid,name,strength) values(?,?,?);";
		College obj = college.get(0);
		try {
			st = con.prepareStatement(query);
			st.setInt(1, obj.getCid());
			st.setString(2, obj.getName());
			st.setInt(3, obj.getStrength());
			st.executeUpdate();
			String s = it.addStudent(obj.getStudent());
			str = "College ID with '" + obj.getCid() + "' was succesfully inserted";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectionFailedException.closeResource(st);
				ConnectionFailedException.closeResource(con);

			} catch (ConnectionFailedException e) {
				throw new ConnectionFailedException();

			}

		}
		return str;
	}

	@Override
	public List<College> displayCollegeDetails() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from college;";
		List<College> clg = new ArrayList<College>();
		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				List<Student> item = new ArrayList<Student>();
				int cid = res.getInt("cid");
				String name = res.getString("name");
				int strength = res.getInt("strength");
				String query = "select * from student where cid='" + cid + "';";
				Statement st2 = con.createStatement();
				ResultSet res2 = st2.executeQuery(query);
				while (res2.next()) {
					Student itm = new Student(res2.getInt("sid"), res2.getString("sname"), res2.getShort("age"),
							res2.getString("subject"), res2.getInt("cid"));
					item.add(itm);
				}
				College sh = new College(cid, name, strength, item);
				clg.add(sh);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clg;
	}

	public TreeSet<String> displayStudentsByAge() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select c.cid, c.name,s.subject,s.age from college c inner join student s on c.cid=s.cid order by s.age desc;";
		TreeSet<String> clg = new TreeSet<String>();
		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				String cid = res.getString("cid");
				String name = res.getString("name");
				String subject = res.getString("subject");
				String age = res.getString("age");
				clg.add(cid);
				clg.add(name);
				clg.add(subject);
				clg.add(age);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clg;
	}

}
