package collegecodingchallenge.CollegeCodingChallenge.service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import collegecodingchallenge.CollegeCodingChallenge.exceptions.ConnectionFailedException;
import collegecodingchallenge.CollegeCodingChallenge.exceptions.NoSuchCollegeException;
import collegecodingchallenge.CollegeCodingChallenge.model.College;

public interface CollegeService {

	String addCollegeDetails(List<College> college);

	List<College> displayCollegeDetails() throws ConnectionFailedException;

	HashMap<String, String> displayStudentsByAge() throws NoSuchCollegeException;

	void displayCollegeName();

}
