package dao;
import model.Department;
import java.util.*;
public interface Departmentservice {
      // no implementation
	// get all details from department table
	public List<Department> getAllDepartmentss(); // get all details

	public Department getDept(int deptid); // get details by their id

	public boolean deleteDepartment(int deptid);
}
