package com.test.hr.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;


import java.util.Date;

/**
 * The persistent class for the Employee database table.
 * 
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeid;

	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;

	@Temporal(TemporalType.DATE)
	private Date hiredate;
	private BigDecimal salary;
	
	private Integer managerid;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class)
	@JoinColumn(name="departmentid", referencedColumnName = "departmentid", nullable = false)
	private Department department;
	

	public Integer getEmployeeid() {
		return employeeid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Integer getManagerid() {
		return managerid;
	}

	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	

}