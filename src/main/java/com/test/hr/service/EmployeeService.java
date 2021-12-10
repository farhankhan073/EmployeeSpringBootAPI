package com.test.hr.service;

import java.util.List;

import com.test.hr.exception.CustomException;
import com.test.hr.models.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee) throws CustomException;

	Employee updateEmployee(Employee employee) throws CustomException;

	List<Employee> findAllEmployee() throws CustomException;

	String deleteEmployee(Integer id) throws CustomException;

}
