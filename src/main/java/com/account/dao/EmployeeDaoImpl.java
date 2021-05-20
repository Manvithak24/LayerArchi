package com.account.dao;

import java.util.ArrayList;
import java.util.List;

import com.account.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> getEmployee() {
		List<Employee> ls = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setEmpName("Manvi");
		emp.setEmpNo(1);
		ls.add(emp);
		Employee emp1 = new Employee();
		emp1.setEmpName("ABCD");
		emp1.setEmpNo(1);
		ls.add(emp1);
		return ls;
	}

}
