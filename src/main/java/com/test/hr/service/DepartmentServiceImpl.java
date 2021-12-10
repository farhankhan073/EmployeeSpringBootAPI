package com.test.hr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.hr.exception.CustomException;
import com.test.hr.models.Department;
import com.test.hr.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository arg) {
		super();
		this.departmentRepository = arg;
	}

	@Override
	public Department saveDepartment(Department department) throws CustomException {
		try {
			return departmentRepository.save(department);
		} catch (Exception e) {
			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage("Department not saved");
			throw ce;
		}

	}

	@Override
	public Department updateDepartment(Department department) throws CustomException {

		
		try {
			return departmentRepository.save(department);
		} catch (Exception e) {
			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage("Department not updated");
			throw ce;
		}

	}

	@Override
	public List<Department> findAllDepartment() throws CustomException {
		List<Department> departmentList = new ArrayList<Department>();
		try {
			departmentList = departmentRepository.findAll();
			return departmentList;
		} catch (Exception e) {
			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage("Department List is null");
			throw ce;
		}

		
	}

	@Override
	public String deleteDepartment(Integer id) throws CustomException {
		try {
			departmentRepository.deleteById(id);
			return "SUCCESS";
		} catch (Exception e) {

			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage("Department is not deleted");
			throw ce;

		}
	}

}
