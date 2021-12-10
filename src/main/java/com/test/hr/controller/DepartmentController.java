package com.test.hr.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.hr.exception.CustomException;
import com.test.hr.models.Department;
import com.test.hr.service.DepartmentService;

@CrossOrigin
@RestController
@RequestMapping("/hr")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	// List Department API
	@RequestMapping(method = RequestMethod.GET, value = "/getdepartment")
	public List<Department> getAllDepartment() throws CustomException {

		List<Department> departmentList = new ArrayList<Department>();
		try {
			departmentList = departmentService.findAllDepartment();
			return departmentList;
		} catch (Exception e) {

			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage(e.getMessage());
			throw ce;

		}

	}

	// Save Department API
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(method = RequestMethod.POST, value = "/savedepartment")
	public Map<String, String> saveDepartment(@RequestBody Department department) throws CustomException {
		try {

			Department resultDepartment = departmentService.saveDepartment(department);

			if (resultDepartment != null && !resultDepartment.equals("")) {
				return Collections.singletonMap("message", "Department saved successfully");
			}
		} catch (Exception e) {


			CustomException ce = new CustomException();
			ce.setCode(10);
			ce.setMessage(e.getMessage());
			throw ce;

		}
		return null;

	}

	// Update Department API
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(method = RequestMethod.PUT, value = "/updatedepartment")
	public Map<String, String> updateDepartment(@RequestBody Department department) throws CustomException {
		try {
			Department resultDepartment = departmentService.updateDepartment(department);

			if (resultDepartment != null && !resultDepartment.equals("")) {
				return Collections.singletonMap("message", "Department updated successfully");
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
