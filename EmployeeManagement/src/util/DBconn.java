package util;

import java.sql.*;
import java.util.*;
import java.io.*;
public class DBconn {

	private static Connection connection;
	 
    public static Connection getConnection() {

        if (connection == null) {

            try {
                Properties properties = DBproperty.getProperties();
                String url = properties.getProperty("db.url");
                String username = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");
                // Step 1& 2 : Load the Driver and establish the connection
                connection = DriverManager.getConnection(url, username, password);
                } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
