package com.SpringBootJDBC.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SpringBootJDBC.model.Employee;


@Repository
public class EmployeeJdbcRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//private static String SELECT_QUERY = "SELECT emp.id as employeeid,emp.firstname as firstName,emp.lastname as lastName,emp.mobilenumber as mobileNumber,emp.email as email,emp.age as age FROM EMPLOYEE emp";
	private static String SELECT_QUERY ="SELECT * FROM EMPLOYEE";
	private static String INSERT_QUERY = "INSERT INTO EMPLOYEE(ID,FIRSTNAME,LASTNAME,MOBILENUMBER,EMAIL,AGE) VALUES(?,?,?,?,?,?)";

	private static String FIND_EMPLOYEE_QUERY = "SELECT * FROM EMPLOYEE WHERE ID=?";

	private static String UPDATE_QUERY = "UPDATE EMPLOYEE SET FIRSTNAME=?,LASTNAME=?,MOBILENUMBER=?,EMAIL=?,AGE=? WHERE ID=?";
	private static String DELETE_QUERY = "DELETE  FROM EMPLOYEE WHERE ID=? ";

	public List<Employee> findAllEmployees() {

		return jdbcTemplate.query(SELECT_QUERY, new BeanPropertyRowMapper<>(Employee.class));
	}

	public int createEmployee(Employee employee) {
		return jdbcTemplate.update(INSERT_QUERY,employee.getId(), employee.getFirstName(),
				employee.getLastName(), employee.getMobileNumber(), employee.getEmail(), employee.getAge());
	}
	
	public Employee finEmployee(Long id)
	{
		Employee employee;
		try {
			employee= jdbcTemplate.queryForObject(FIND_EMPLOYEE_QUERY, new BeanPropertyRowMapper<>(Employee.class),id);
			
		} catch (EmptyResultDataAccessException e) 
		{
			throw new com.SpringBootJDBC.Exception.EmployeeNotFoundException("Employee Not found"+id);
			// TODO: handle exception
		}
		return  employee;
	}
	public Integer updateEmployee(Employee employee)
	{
		return jdbcTemplate.update(UPDATE_QUERY ,employee.getFirstName(),employee.getLastName(),employee.getMobileNumber(),employee.getEmail(),employee.getAge(), employee.getId());
		
	}
	public Integer deleteEmployee(Long id)
	{
		return jdbcTemplate.update(DELETE_QUERY,id);
	}

}
