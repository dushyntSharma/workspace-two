package collegecodingchallenge.CollegeCodingChallenge.dao;

import java.util.HashMap;
import java.util.List;

import collegecodingchallenge.CollegeCodingChallenge.exceptions.ConnectionFailedException;
import collegecodingchallenge.CollegeCodingChallenge.exceptions.NoSuchCollegeException;
import collegecodingchallenge.CollegeCodingChallenge.model.College;

public interface CollegeDao {

	String addCollegeDetails(List<College> college) throws ConnectionFailedException;

	List<College> displayCollegeDetails() throws ConnectionFailedException;

	HashMap<String, String> displayStudentsByAge() throws NoSuchCollegeException;

	void displayCollegeName();

}
