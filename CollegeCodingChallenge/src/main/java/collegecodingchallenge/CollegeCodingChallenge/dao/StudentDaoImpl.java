package collegecodingchallenge.CollegeCodingChallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import collegecodingchallenge.CollegeCodingChallenge.model.Student;
import collegecodingchallenge.CollegeCodingChallenge.utility.DBConnection;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String addStudent(List<Student> student) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		String query2 = "insert into student(sid,sname,age,subject,cid) values(?,?,?,?,?);";
		try {
			for (int i = 0; i < student.size(); i++) {
				st = con.prepareStatement(query2);
				st.setInt(1, student.get(i).getSid());
				st.setString(2, student.get(i).getSname());
				st.setShort(3, student.get(i).getAge());
				st.setString(4, student.get(i).getSubject());
				st.setInt(5, student.get(i).getCid());
				st.execute();

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
