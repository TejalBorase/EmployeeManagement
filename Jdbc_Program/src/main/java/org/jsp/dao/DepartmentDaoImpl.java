package org.jsp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.jsp.entity.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	private Connection connection;
	private PreparedStatement pstmt;
	// Non-static block
	{
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/advjavae2?user=root&password=sql123";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url);
			System.out.println("*****Connection Established*****");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// dept is used to take input from user
	public int addDepartment(Department dept) throws SQLException {
		System.out.println("*****addDepartment method executed*****");
		String query = "insert into Department values(?,?)";
		pstmt = connection.prepareStatement(query);
		// assign values for placeholder
		pstmt.setInt(1, dept.getDeptNo());
		pstmt.setString(2, dept.getDname());
		// execute query
		int noOfRecord = pstmt.executeUpdate();
		return noOfRecord;
	}

	public Department getDepartmentById(int id) throws SQLException {
		String query = "select * from department where deptNo = ?";
		pstmt = connection.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			// deptId is valid
			Department dept = new Department();
			// fetch data from db
			int deptId = rs.getInt("deptNo");
			String dname = rs.getString("dname");
			// store above data into department object
			dept.setDeptNo(deptId);
			dept.setDname(dname);
			return dept;
		}
		// deptId is invalid
		return null;

	}

	public List<Department> getAllDepartments() throws SQLException {
		String query = "SELECT * from Department";
		pstmt = connection.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		//Create list of Departments
		List<Department> departments = new ArrayList<Department>();
		
		if(rs.isBeforeFirst()) {
			//fetch data
			while(rs.next()) {
				//1. fetch data from db
				int deptNo = rs.getInt("deptNo");
				String dname = rs.getString("dname");
				//2. create department object
				Department dept = new Department();
				//3. store data into department object
				dept.setDeptNo(deptNo);
				dept.setDname(dname);
				//4. store department object into list
				departments.add(dept);
			}
			return departments;
		}
		return null;
	}

	public int deleteById(int id) throws SQLException {
		String query = "delete from department where deptNo = ?";
		pstmt = connection.prepareStatement(query);
		pstmt.setInt(1, id);
		
		return pstmt.executeUpdate();
	}

	public int updateDepartment(Department department) throws SQLException {
		String query = "update Department set dname = ? where deptNo = ?";
		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, department.getDname());
		pstmt.setInt(2, department.getDeptNo());
	
		return pstmt.executeUpdate();
	}

}








