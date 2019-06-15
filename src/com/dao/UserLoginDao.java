package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.UserDetails;

public class UserLoginDao {

	private Connection connection;
	
	private Statement statement;
	
	private static String dburl = "jdbc:postgresql://localhost:5555/personal_finance";
	
	private static String username = "postgres";
	
	private static String password = "ravi";
	
	public UserLoginDao() {
		System.out.println("constrcutor");
		
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println("main method");
		UserLoginDao dao = new UserLoginDao();
		dao.getUserDetails();
		
		UserDetails details = dao.validateUser("ravi", "ravi1234");
		System.out.println("Value is : "+details);
	}
	
	static {
		System.out.println("Static block....");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void createConnection() {
		try {
			connection = DriverManager.getConnection(dburl,username,password);
				
			if(connection != null) {
				System.out.println("Connection created...");
			}else {
				System.out.println("Connection not created...");
			}
		} catch (SQLException e) {
			System.out.println("Error while creating Connection ...");
			e.printStackTrace();
		}
	}
	
	public List<UserDetails> getUserDetails() throws SQLException {
		System.out.println("User detail method.......");
		List<UserDetails> list = new ArrayList<UserDetails>();
		try {
			createConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from user_details");
			System.out.println("Query executed successfully.....");
			if(result != null) {
				while (result.next()) {
					
				/*	System.out.println("id : "+result.getInt(1));
					System.out.println("username : "+result.getString(2));
					System.out.println("password : "+result.getString(3));
					System.out.println("login date : "+result.getDate(3));*/
/*					System.out.println("-----------------------------------");
					System.out.println("id : "+result.getInt("id"));
					System.out.println("username : "+result.getString("user_name"));
					System.out.println("password : "+result.getString("password"));
					System.out.println("login date : "+result.getDate("login_date"));
					System.out.println("-----------------------------------");*/
					UserDetails ud = new UserDetails();
					ud.setId(result.getInt("id"));
					ud.setUserName(result.getString("user_name"));
					ud.setPassword(result.getString("password"));
					ud.setLoginDate(result.getDate("login_date"));
					list.add(ud);				
				}
				for(UserDetails u : list) {
					System.out.println(u);
				}
			}else {
				System.out.println("No Results found..");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				System.out.println("Closing connection...");
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
		}
		System.out.println("Executed method...");
		return list;
	}

	
	public UserDetails validateUser(String username, String password) throws SQLException  {
		UserDetails ud = null;
		try {
			String query = "select * from user_details where user_name='" + username + "'and password='" + password+ "'";
			System.out.println("query is : " + query);
			createConnection();
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			System.out.println("Query executed successfully.....");
			if (result != null) {
				while (result.next()) {
					ud = new UserDetails();
					ud.setId(result.getInt("id"));
					ud.setUserName(result.getString("user_name"));
					ud.setPassword(result.getString("password"));
					ud.setLoginDate(result.getDate("login_date"));
				}
			}
		}catch (Exception e) {
			System.out.println("Exception while executing query");
			e.printStackTrace();
		}finally {
			// resource releasing..
			if(connection != null) {
				System.out.println("Closing connection...");
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
		}
		return ud;
	}
	
}