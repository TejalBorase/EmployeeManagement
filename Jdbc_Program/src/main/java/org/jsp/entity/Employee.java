package org.jsp.entity;

//to represent table - Entity class
public class Employee {

	private int empId;
	private String ename;
	private String email;
	private long mobile;
	private double salary;
	private int deptNo;

	public int getEmpId() {
		return empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + ", email=" + email + ", mobile=" + mobile + ", salary="
				+ salary + ", deptNo=" + deptNo + "]";
	}

}
