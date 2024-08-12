package org.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.jsp.entity.Department;

//Dao - Data Access Object - to write code, to perform operations on DB
public interface DepartmentDao {
	// to add department into table
	int addDepartment(Department dept) throws SQLException;
	
	//to fetch department based on id
	Department getDepartmentById(int id)throws SQLException;
	
	//to fetch all departments
	List<Department> getAllDepartments() throws SQLException;
	
	//to delete data by id
	int deleteById(int id) throws SQLException;
	
	//update department details
	int updateDepartment(Department department)throws SQLException;
}













