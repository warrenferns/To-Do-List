package com.java.todolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.cj.xdevapi.Statement;
import java.sql.*;

public class ToDoListDAO {
	public void addTask(Task task) throws SQLException, ClassNotFoundException{
		String INSERT_USERS_SQL = "INSERT INTO list" +
	            "  (taskName,employee,date,isDone) VALUES " +
	            " (?,?,?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/todolist?useSSL=false", "root", "walwin");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            
	            preparedStatement.setString(1, task.getName());
	            preparedStatement.setString(2, task.getEmp());
	            preparedStatement.setDate(3, new java.sql.Date( task.getDeadline().getTime()));
	            preparedStatement.setBoolean(4, task.isStatus());
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        }
	}
	public void renameTask(String old, String newN) throws SQLException, ClassNotFoundException{
		String INSERT_USERS_SQL = "UPDATE list SET taskName = ? WHERE taskName = ?";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/todolist?useSSL=false", "", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            
	            preparedStatement.setString(1, newN);
	            preparedStatement.setString(2, old);
	            //preparedStatement.setString(3, task.getDate());
	            
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        }
	}
	public void removeTask(String name) throws SQLException, ClassNotFoundException{
		String INSERT_USERS_SQL = "DELETE FROM list WHERE taskName = ?";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/todolist?useSSL=false", "root", "walwin");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            
	            preparedStatement.setString(1, name);
	            
	            //preparedStatement.setString(3, task.getDate());
	            
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        }
	}
	public void modifyDeadLine(String task, Date date) throws SQLException, ClassNotFoundException{
		String INSERT_USERS_SQL = "UPDATE list SET date = ? WHERE taskName = ?";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/todolist?useSSL=false", "root", "walwin");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            
	            preparedStatement.setString(2, task);       
	            preparedStatement.setDate(1, new java.sql.Date( date.getTime()));
	           
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        }
	}
	public void assignTask(String task, String employee) throws SQLException, ClassNotFoundException{
		String INSERT_USERS_SQL = "UPDATE list SET employee = ? WHERE taskName = ?";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/todolist?useSSL=false", "root", "walwin");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            
	            preparedStatement.setString(2, task);       
	            preparedStatement.setString(1, employee);
	           
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        }
	}
	public void markAsDone(String task) throws SQLException, ClassNotFoundException{
		String INSERT_USERS_SQL =  "UPDATE list SET isDone = '1' WHERE taskName = ?";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/todolist?useSSL=false", "root", "walwin");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	           
	            preparedStatement.setString(1, task);    
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        }
	}
	public ResultSet viewList() throws SQLException, ClassNotFoundException{
		ResultSet rs=null;
		try
        { 
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist?useSSL=false", "root", "walwin"); 
            java.sql.Statement stmt = con.createStatement(); 
              
            // SELECT query 
            String q1 = "select * from list"; 
             rs = stmt.executeQuery(q1); 
//            while(rs.next()) 
//            { 
//            	System.out.println("***********************");
//    			System.out.println(rs.getString(1)); 	
//    			System.out.println(rs.getString(2));
//    	        System.out.printf("%s %tB %<te, %<tY", "Due date:", rs.getDate(3));
//    	        System.out.println(); 	
//    	        System.out.println(rs.getString(4));
//    	        System.out.println("***********************");
//            } 
            
            
        } 
        catch(Exception e) 
        { 
            System.out.println(e); 
        } 
		
		return rs;
	}
}
