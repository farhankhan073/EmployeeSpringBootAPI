package com.test.hr.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.hr.exception.CustomException;
import com.test.hr.models.Employee;
import com.test.hr.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/hr")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// List Employee API
	@RequestMapping(method = RequestMethod.GET, value = "/getemployee")
	public List<Employee> getAllEmployee() throws CustomException {

		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			employeeList = employeeService.findAllEmployee();
			return employeeList;
		} catch (Exception e) {
			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage(e.getMessage());
			throw ce;

		}

	}

	// Save Employee API
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(method = RequestMethod.POST, value = "/saveemployee")
	public Map<String, String> saveEmployee(@RequestBody Employee employee) throws CustomException {
		try {

			Employee resultEmployee = employeeService.saveEmployee(employee);

			if (resultEmployee != null && !resultEmployee.equals("")) {
				return Collections.singletonMap("message", "Employee saved successfully");
			}
		} catch (Exception e) {

			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage(e.getMessage());
			throw ce;

		}
		return null;

	}

	// Update Employee API
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(method = RequestMethod.PUT, value = "/updateemployee")
	public Map<String, String> updateEmployee(@RequestBody Employee employee) throws CustomException {
		try {
			Employee resultEmployee = employeeService.updateEmployee(employee);

			if (resultEmployee != null && !resultEmployee.equals("")) {
				return Collections.singletonMap("message", "Employee updated successfully");
			}

		} catch (Exception e) {


			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage(e.getMessage());
			throw ce;

		}
		return null;

	}

	// Delete Employee  API
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteemployee/{id}")
	public Map<String, String> deleteAccountingcycle(@PathVariable int id) throws CustomException {
		try {
			String resultEmployee = employeeService.deleteEmployee(id);
			if (resultEmployee != null && !resultEmployee.equals("")) {
				return Collections.singletonMap("message", "Employee deleted successfully");
			}

		} catch (Exception e) {


			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage(e.getMessage());
			throw ce;

		}
		return null;

	}

}
