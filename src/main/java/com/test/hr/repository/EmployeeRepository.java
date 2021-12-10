package com.test.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.hr.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	Employee findByemail(String email);

}