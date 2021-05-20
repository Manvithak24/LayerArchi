package com.account.dto;

public class Employee {
	private int empNo;
	private String empName;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String toString()
	{
		return "name : "+getEmpName()+"	Id : "+getEmpNo();
	}
	
}
