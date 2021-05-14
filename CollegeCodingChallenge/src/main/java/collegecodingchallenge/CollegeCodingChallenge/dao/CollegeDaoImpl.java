package collegecodingchallenge.CollegeCodingChallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import collegecodingchallenge.CollegeCodingChallenge.exceptions.ConnectionFailedException;
import collegecodingchallenge.CollegeCodingChallenge.exceptions.NoSuchCollegeException;
import collegecodingchallenge.CollegeCodingChallenge.model.College;
import collegecodingchallenge.CollegeCodingChallenge.model.Student;
import collegecodingchallenge.CollegeCodingChallenge.service.CollegeService;
import collegecodingchallenge.CollegeCodingChallenge.service.CollegeServiceImpl;
import collegecodingchallenge.CollegeCodingChallenge.utility.DBConnection;

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
	public List<College> displayCollegeDetails() throws ConnectionFailedException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from college;";
		Statement st = null;
		ResultSet res = null;
		List<College> clg = new ArrayList<College>();
		try {

			st = con.createStatement();
			res = st.executeQuery(sql);
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
		} finally {
			try {
				ConnectionFailedException.closeResource(res);
				ConnectionFailedException.closeResource(st);
				ConnectionFailedException.closeResource(con);

			} catch (ConnectionFailedException e) {
				throw new ConnectionFailedException();

			}

		}

		return clg;
	}

	@Override
	public HashMap<String, String> displayStudentsByAge() throws NoSuchCollegeException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select s.sname,s.age from college c inner join student s on c.cid=s.cid order by s.age desc;";
		HashMap<String, String> clg = new HashMap<String, String>();

		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				String name = res.getString("sname");
				String age = res.getString("age");
				clg.put(age, name);

			}
			Map<String, String> map = new TreeMap<String, String>(clg);
			Map<String, String> map1 = new TreeMap<String, String>(Collections.reverseOrder());

			map1.putAll(map);
			System.out.println(map1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clg;
	}

	@Override
	public void displayCollegeName() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select c.cid,c.name,s.sname,s.age from college c inner join student s on c.cid=s.cid order by c.name asc;";
		Statement st = null;
		ResultSet res = null;
		List<String> list = new ArrayList<String>();
		try {
			st = con.createStatement();
			res = st.executeQuery(sql);
			while (res.next()) {
				String cid = res.getString("cid");
				String name = res.getString("name");
				String sname = res.getString("sname");
				String age = res.getString("age");
				list.add(cid);
				list.add(name);
				list.add(sname);
				list.add(age);

			}

			System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
