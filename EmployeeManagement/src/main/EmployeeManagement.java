package main;

import java.util.Scanner;
import dao.Departmentserviceimpl;

public class EmployeeManagement {

	public static void main(String[] args) {
    int option;
    System.out.println("1. display all department details");
    System.out.println("2. display department details by dept id");
    System.out.println("3. Delete department by dept id");

    Scanner s1=new Scanner(System.in);
    System.out.println("Choose the option");
    option=s1.nextInt();
    
    switch(option) 
    {
    case 1:
    	System.out.println("Department details are:");
    	Departmentserviceimpl obj=new Departmentserviceimpl();
    	obj.getAllDepartmentss();
    	break;
    case 2:
    	System.out.println("Department details by dept id:");
    	Departmentserviceimpl obj2=new Departmentserviceimpl();
    	System.out.println("enter dept id:");
    	Scanner sc=new Scanner(System.in);
    	int deptId = sc.nextInt();
    	obj2.getDept(deptId);
    	break;
    case 3:
    	System.out.println("Enter the Department ID to delete:");
        int deleteId = s1.nextInt();
    	Departmentserviceimpl obj3=new Departmentserviceimpl();
        obj3.deleteDepartment(deleteId);  // call delete method
        System.out.println("Department deleted successfully (if existed).");
        break;
    default:
    	System.out.println("invalid option");
    }
	}

}
