package codingchallenge.CodingChallenge.service;

import java.util.List;
import java.util.TreeSet;

import codingchallenge.CodingChallenge.model.College;

public interface CollegeService {

	String addCollegeDetails(List<College> college);

	List<College> displayCollegeDetails();

	TreeSet<String> displayStudentsByAge();

}
