package DAO;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class dbc {

	   public static Connection CreateConnexion() {
		 Connection connection = null;
	     String url = "jdbc:mysql://localhost:3306/projet_jee"; 
	     String username = "root";
	     String password = "";
	     try {   
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("Okkkk");
	        }
	        catch (ClassNotFoundException e) {
	            e.printStackTrace();}
	            connection = (Connection) DriverManager.getConnection(url, username, password);
	            System.out.println("Post establishing a DB connection -"+connection);
	            System.out.println("Okkkk");}
	     catch (Exception e) {
	         e.printStackTrace();} 
	        return  connection;
	   }
	}