package employeeproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import employeeproject.model.Employee;
import employeeproject.utility.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addEmployeeDetails(List<Employee> emp) {
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		String str = null;
		String query = "insert into employee(id,name,designation,salary) values(?,?,?,?);";
		Employee obj = Employee.get
		try {
			st = con.prepareStatement(query);
			st.setInt(1, obj);
			st.setString(2, obj.getShopName());
			st.setString(3, obj.getAddress());
			st.executeUpdate();
			String s = it.addItem(obj.getItem());
			str = "Shop ID with '" + obj.getShopId() + "' was succesfully inserted";
	}catch (Exception e) {
		// TODO: handle exception
	}

}
}
