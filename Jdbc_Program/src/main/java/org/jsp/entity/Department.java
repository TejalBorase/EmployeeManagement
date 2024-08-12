package org.jsp.entity;

//to represent table - Entity class
//to transfer data
public class Department {

	// to represent column - variables
	private int deptNo;
	private String dname;

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", dname=" + dname + "]";
	}

}
