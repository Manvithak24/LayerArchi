package com.unit.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.account.dao.EmployeeDao;
import com.account.dto.Employee;
import com.account.service.EmpService;
import com.account.service.EmpServiceImpl;


@RunWith(MockitoJUnitRunner.class)
class EmpTest {
	static EmpService employeeService = null;
	static EmployeeDao mockEmployeeDao=null;
	public static Employee emp1;
	public static Employee emp2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		mockEmployeeDao = Mockito.mock(EmployeeDao.class);
		employeeService = new EmpServiceImpl(mockEmployeeDao);
		emp1 = new Employee();
		emp1.setEmpName("Alex");
		emp1.setEmpNo(101);
		emp2= new Employee();
		emp2.setEmpName("Tom");
		emp2.setEmpNo(102);
		
		Mockito.when(mockEmployeeDao.getEmployee()).thenReturn(Arrays.asList(emp1,emp2));
	}
		

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//fail("Not yet implemented");
		List<Employee> emplist = employeeService.getEmployee();
		assertEquals(2, emplist.size());
	}

}
