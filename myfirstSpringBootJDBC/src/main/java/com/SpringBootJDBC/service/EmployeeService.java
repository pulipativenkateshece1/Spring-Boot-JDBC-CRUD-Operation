package com.SpringBootJDBC.service;

import java.util.List;

import com.SpringBootJDBC.model.Employee;

public interface EmployeeService
{
	List<Employee> findAllEmployees();
	
	int createEmployee(Employee employee);
	
	Employee findEmployee(Long id);
	
	Integer updateEmployee(Employee employee);
	Integer deleteEmployee(Long id);

}
