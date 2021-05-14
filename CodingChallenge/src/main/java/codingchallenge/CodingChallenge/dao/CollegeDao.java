package codingchallenge.CodingChallenge.dao;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import codingchallenge.CodingChallenge.exceptions.ConnectionFailedException;
import codingchallenge.CodingChallenge.model.College;

public interface CollegeDao {

	String addCollegeDetails(List<College> college) throws ConnectionFailedException;

	List<College> displayCollegeDetails();

	TreeSet<String> displayStudentsByAge();

}
