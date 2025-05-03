package dao;

import java.util.*;

import exception.DepartmentNotFoundException;

import java.sql.* ;


 import model.Department ;
 import util.DBconn;
 
public class Departmentserviceimpl implements Departmentservice { 
	@Override
	public List<Department> getAllDepartmentss() {
		List<Department> list =new ArrayList<>();//object created 
		String query="Select * from Department"; 
		try(Connection con=DBconn.getConnection(); 
			PreparedStatement ps=con.prepareStatement(query)) 
		{ 
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{ 
				//list.add(new Department(rs.getInt("deptid"),rs.getString("deptname"))); 
			int departmentID = rs.getInt("deptid");
	        String departmentName = rs.getString("deptname"); 
	        System.out.println("ID: " + departmentID + ", Name: " + departmentName); 
			} 
		}
		catch(Exception e) 
		{ 
			System.out.println(e);
		}
		
		// TODO Auto-generated method stub
		return list;
	} 
	@Override
	public Department getDept(int deptid) {
		String sql = "SELECT * FROM Department WHERE deptid = ?";
		Department dept = null;
        try(Connection conn = DBconn.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, deptid);
            ResultSet rs = stmt.executeQuery();
            int departmentID=0;
            if(rs!=null)
            {
            while(rs.next())
			{
				//list.add(new Department(rs.getInt("deptid"),rs.getString("deptname")));
            departmentID = rs.getInt("deptid");
            String departmentName = rs.getString("deptname");
            System.out.println("ID: " + departmentID + ", Name: " + departmentName);
			}
            }
            if(departmentID != deptid)
            throw new DepartmentNotFoundException("Department with depid: " + deptid + " not found");
            return dept;
        } catch (DepartmentNotFoundException e) {
            System.out.println( e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error Occurred : " + e.getMessage());
        
        }
       return null;
	}
	@Override
	public boolean deleteDepartment(int deptid) {
	    String sql = "DELETE FROM Department WHERE deptid = ?";
	    
	    try (Connection conn = DBconn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, deptid);
	        int rowsAffected = stmt.executeUpdate(); // executeUpdate for insert/update/delete
	        
	        if (rowsAffected > 0) {
	            System.out.println("Department with ID " + deptid + " deleted successfully.");
	            return true;
	        } else {
	            System.out.println("No department found with ID " + deptid + ".");
	            return false;
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
 
 
}
