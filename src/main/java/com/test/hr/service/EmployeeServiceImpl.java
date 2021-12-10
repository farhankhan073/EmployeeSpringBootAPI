package com.test.hr.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.hr.exception.CustomException;
import com.test.hr.models.Employee;
import com.test.hr.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;



	public EmployeeServiceImpl(EmployeeRepository arg) {
		super();
		this.employeeRepository = arg;
	}

	@Override
	public Employee saveEmployee(Employee employee) throws CustomException {

		if (!validation(employee)) {

			return employeeRepository.save(employee);
		}
		return null;

	}

	@Override
	public Employee updateEmployee(Employee employee) {

		return employeeRepository.save(employee);

	}

	
	
	
	public boolean validation(Employee employee) throws CustomException {

		Employee employeeEmail = employeeRepository.findByemail(employee.getEmail());

		if (employeeEmail != null && !employeeEmail.equals("")) {
			
			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage("Employee arleady exists");
			throw ce;
		}

		if (employee.getFirstname() != null && !employee.getFirstname().equals("") && (employee.getFirstname().length()<3)) {
			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage("First name must be at least 3 characters");
			throw ce;
		}
		
		if (employee.getLastname() != null && !employee.getLastname().equals("") && (employee.getLastname().length()<3)) {
			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage("Last name must be at least 3 characters");
			throw ce;
		}
		
		if (employee.getSalary() != null && !employee.getSalary().equals("") && (employee.getSalary().compareTo(new BigDecimal(0)) == 0)) {
			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage("Salary must be greater then 0");
			throw ce;
		}
		
		 
		if (employee.getPhonenumber() != null && !employee.getPhonenumber().equals("")) {
			if (employee.getPhonenumber().matches("\\d{1,10}")
					||employee.getPhonenumber().matches("\\d{1,10}[\\-]")
					||employee.getPhonenumber().matches("\\d{1,10}[\\-]\\d{1,10}")
					||employee.getPhonenumber().matches("\\d{1,10}[\\-]\\d{1,10}[\\-]\\d{1,10}")
					||employee.getPhonenumber().matches("\\d{1,10}[\\-]\\d{1,10}[\\-]\\d{1,10}[\\-]\\d{1,10}")) 
				{
				
				}
			else {
				CustomException ce = new CustomException();
				ce.setCode(10);
				ce.setMessage("Enter only digits and hyphen");
				throw ce;
			}
		
		
		}
		return false;

	}

	@Override
	public List<Employee> findAllEmployee()  throws CustomException{
		
		try {
			List<Employee> employeeList = new ArrayList<Employee>();
			employeeList = employeeRepository.findAll();
			return employeeList;
		} catch (Exception e) {
			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage("Employee List is null");
			throw ce;
		}

		
	}

	@Override
	public String deleteEmployee(Integer id) throws CustomException {
		try {
			employeeRepository.deleteById(id);
			return "SUCCESS";
		} catch (Exception e) {

			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage("Employee is not deleted");
			throw ce;

		}
	}

}
