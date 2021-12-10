package com.test.hr.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Department database table.
 * 
 */
@Entity
@Table(name = "department")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departmentid",length=4, unique = true, nullable = false, insertable = false, updatable = false)
	private Integer departmentid;

	@Column(length = 30)
	private String departmentname;
	
	@Column(name = "managerid",length=6)
	private Integer managerid;

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public Integer getManagerid() {
		return managerid;
	}

	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
	}

}