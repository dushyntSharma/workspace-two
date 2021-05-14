package collegecodingchallenge.CollegeCodingChallenge.service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import collegecodingchallenge.CollegeCodingChallenge.dao.CollegeDao;
import collegecodingchallenge.CollegeCodingChallenge.dao.CollegeDaoImpl;
import collegecodingchallenge.CollegeCodingChallenge.dao.StudentDao;
import collegecodingchallenge.CollegeCodingChallenge.dao.StudentDaoImpl;
import collegecodingchallenge.CollegeCodingChallenge.exceptions.ConnectionFailedException;
import collegecodingchallenge.CollegeCodingChallenge.exceptions.NoSuchCollegeException;
import collegecodingchallenge.CollegeCodingChallenge.model.College;

public class CollegeServiceImpl implements CollegeService {

	static CollegeDao dao = new CollegeDaoImpl();
	static StudentDao cdao = new StudentDaoImpl();

	@Override
	public String addCollegeDetails(List<College> college) {
		// TODO Auto-generated method stub
		String s = null;
		try {
			s = dao.addCollegeDetails(college);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<College> displayCollegeDetails() throws ConnectionFailedException {
		// TODO Auto-generated method stub
		List<College> shop = dao.displayCollegeDetails();
		return shop;
	}

	@Override
	public HashMap<String, String> displayStudentsByAge() throws NoSuchCollegeException {
		// TODO Auto-generated method stub
		HashMap<String, String> s = dao.displayStudentsByAge();
		return s;
	}

	@Override
	public void displayCollegeName() {
		// TODO Auto-generated method stub
		dao.displayCollegeName();

	}

}
