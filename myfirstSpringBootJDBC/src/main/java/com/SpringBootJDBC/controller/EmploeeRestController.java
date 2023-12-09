package com.SpringBootJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootJDBC.model.Employee;
import com.SpringBootJDBC.service.EmployeeService;

@RestController
public class EmploeeRestController 
{
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("findAllEmployees")
	public List<Employee> findAllEmployees()
	{
		return  employeeService.findAllEmployees();
	}
	@PostMapping("/createEmployees")
	public int createEmployee( @RequestBody  Employee employee)
	{
		return employeeService.createEmployee(employee);
	}
	@GetMapping("findEmployee/{id}")
	public Employee finEmployee(@PathVariable Long id)
	{
		return employeeService.findEmployee(id);
		
		
	}
	@PostMapping("findEmployee")
	public Employee fiEmployee(@RequestBody Employee employee)
	{
		return employeeService.findEmployee(employee.getId());
	}
	@PutMapping("updateEmployee")
	public Integer updateEmployee(@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(employee);
	}
	@DeleteMapping("deleteEmployee/{id}")
	public Integer deleteEmployee(@PathVariable Long id)
	{
		return employeeService.deleteEmployee(id);
		
	}

}
