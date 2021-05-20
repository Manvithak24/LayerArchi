package com.netjs;

import java.util.List;

import com.account.dao.EmployeeDao;
import com.account.dao.EmployeeDaoImpl;
import com.account.dto.Employee;
import com.account.service.EmpService;
import com.account.service.EmpServiceImpl;

public class EmployeeDriver {
	public static void main(String[] args)

	{
		EmployeeDao empDao = new EmployeeDaoImpl();
		EmpService es = new EmpServiceImpl(empDao);
		List<Employee> elist = es.getEmployee();
		System.out.println(elist);
	}
}
