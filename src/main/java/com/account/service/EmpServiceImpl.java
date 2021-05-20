package com.account.service;

import java.util.List;

import com.account.dao.EmployeeDao;
import com.account.dto.Employee;

public class EmpServiceImpl implements EmpService {
    EmployeeDao empDao;
    public EmpServiceImpl(EmployeeDao empDao)
    {
    	this.empDao = empDao;
    }
    
	public List<Employee> getEmployee() {
		List<Employee> empList= empDao.getEmployee();
		return empList;
	}

}
