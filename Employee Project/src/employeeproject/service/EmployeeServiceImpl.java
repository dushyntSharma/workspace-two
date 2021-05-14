package employeeproject.service;

import java.util.List;

import employeeproject.dao.EmployeeDao;
import employeeproject.dao.EmployeeDaoImpl;
import employeeproject.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public String addEmployeeDetails(List<Employee> emp) {
		String s = null;
		try {
			s = dao.addEmployeeDetails(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}
