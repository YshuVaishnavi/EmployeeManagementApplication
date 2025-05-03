package util;
//import java.sql.*;
import java.util.*;
import java.io.*;
public class DBproperty {

	//connection with db.properties
	public static Properties getProperties() 
	 {
	     Properties properties = new Properties(); // create a object for Properties
	   try (InputStream input = DBproperty.class
			.getClassLoader().getResourceAsStream("db.properties")) 
	   {
	          properties.load(input); // try to load the property file
	   } 
	   catch (Exception e)
	   {
	            e.printStackTrace(); // if not catch with exception
	   }
	   return properties;
    }
}