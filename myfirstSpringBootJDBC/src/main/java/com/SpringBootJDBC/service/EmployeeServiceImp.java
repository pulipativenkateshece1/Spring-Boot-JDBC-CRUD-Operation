package com.SpringBootJDBC.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SpringBootJDBC.model.Employee;
import com.SpringBootJDBC.repository.EmployeeJdbcRepository;
@Component
public class EmployeeServiceImp implements EmployeeService 
{
	@Autowired

	
	private EmployeeJdbcRepository employeeJdbcRepository;
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return employeeJdbcRepository.findAllEmployees();
	}

	
	public int createEmployee(Employee employee) 
	{
		// TODO Auto-generated method stub
		 return employeeJdbcRepository.createEmployee(employee);

	}

	
	public Employee findEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeeJdbcRepository.finEmployee(id);
	}

	
	public Integer updateEmployee(Employee employee) 
	{
		return employeeJdbcRepository.updateEmployee(employee);
		// TODO Auto-generated method stub

	}


	public Integer deleteEmployee(Long id)
	{
		return employeeJdbcRepository.deleteEmployee(id);
		// TODO Auto-generated method stub

	}

}
