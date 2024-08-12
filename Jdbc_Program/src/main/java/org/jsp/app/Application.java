package org.jsp.app;
import java.sql.*;
import java.util.List;
import java.util.Scanner;
import org.jsp.dao.*;
import org.jsp.entity.Department;
public class Application {
	public static void main(String[] args) {
		//Create object of DepartmentDao Interface type
		DepartmentDao dao = new DepartmentDaoImpl();
		
		System.out.println("Enter 1 to add Department");
		System.out.println("Enter 2 to search Department by id");
		System.out.println("Enter 3 to get all department details");
		System.out.println("Enter 4 to delete department by id");
		System.out.println("Enter 5 to update department by id");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter choice");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:{
			Department department = new Department();
			System.out.println("Enter Department no");
			int dn = sc.nextInt();
			System.out.println("Enter Department name");
			String dname = sc.next();
			
			//store data into department object
			department.setDeptNo(dn);
			department.setDname(dname);
			System.out.println("****Data is stored in an object*****");
			
			//call addDepartment method
			try {
				int output = dao.addDepartment(department);
				System.out.println("No. of Department added = " + output);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
			break;
		case 2 :{
			System.out.println("Enter department Id");
			int id = sc.nextInt();
			try {
				Department dept = dao.getDepartmentById(id);
				if(dept != null) {
					System.out.println(dept);
				}
				else {
					System.err.println("No Data found...");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			break;
		case 3:{
			try {
				List<Department> departments = dao.getAllDepartments();
				if(departments != null) {
					//print data
					for(Department d : departments) {
						System.out.println(d);
					}
				}
				else {
					System.err.println("No Data Found...");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		break;
		case 4:{
			System.out.println("Enter Department id");
			int id = sc.nextInt();
			try {
				int records = dao.deleteById(id);
				if(records != 0) {
					System.out.println("Record deleted...");
				}
				else {
					System.err.println("no data found...");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		break;
		case 5:{
			Department dept = new Department();
			System.out.println("Enter department no");
			dept.setDeptNo(sc.nextInt());
			System.out.println("Enter department name");
			dept.setDname(sc.next());
			
			try {
				int records	= dao.updateDepartment(dept);
				if(records != 0) {
					System.out.println("Department update");
				}
				else {
					System.err.println("No data found...");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		default:
			break;
		}
	}
}










