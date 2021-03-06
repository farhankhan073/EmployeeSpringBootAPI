package com.test.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.hr.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}