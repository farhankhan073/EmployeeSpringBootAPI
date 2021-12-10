package com.test.hr.service;

import java.util.List;

import com.test.hr.exception.CustomException;
import com.test.hr.models.Department;

public interface DepartmentService {
	
	Department saveDepartment(Department department) throws CustomException;

	Department updateDepartment(Department department) throws CustomException;

	List<Department> findAllDepartment() throws CustomException;

	String deleteDepartment(Integer id) throws CustomException;

}
