package codingchallenge.CodingChallenge.service;

import java.util.List;
import java.util.TreeSet;

import codingchallenge.CodingChallenge.dao.CollegeDao;
import codingchallenge.CodingChallenge.dao.CollegeDaoImpl;
import codingchallenge.CodingChallenge.dao.StudentDao;
import codingchallenge.CodingChallenge.dao.StudentDaoImpl;
import codingchallenge.CodingChallenge.model.College;

public class CollegeServiceImpl implements CollegeService {

	static CollegeDao dao = new CollegeDaoImpl();
	static StudentDao cdao = new StudentDaoImpl();

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
	public List<College> displayCollegeDetails() {
		// TODO Auto-generated method stub
		List<College> shop = dao.displayCollegeDetails();
		return shop;
	}

	@Override
	public TreeSet<String> displayStudentsByAge() {
		// TODO Auto-generated method stub
		TreeSet<String> s = dao.displayStudentsByAge();
		return s;
	}
}
