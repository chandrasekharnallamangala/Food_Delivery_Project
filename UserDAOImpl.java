package com.project.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.DAO.UserDAO;
import com.project.Model.User;

public class UserDAOImpl implements UserDAO 
{
	int x = -1;
	ArrayList<User> al = new ArrayList();
	private	static final String INSERT = "INSERT INTO USER(user_name,password,email,address,role) VALUES(?,?,?,?,?)";
	private static final String FETCH_ALL = "select * from user"; 
	private static final String FETCH_ONE  = "Select * from user where email = ?";
    private static final String DELETE = "Delete from user where user_id = ?";
    private static final String UPDATE = "update user set password = ? where email = ?"; 

	
	static String url= "jdbc:mysql://localhost:3306/project_db";
	static String username = "root";
	static String pwd = "SYSTEM";
	
	User user;
	static Connection connection;
	private	PreparedStatement pstmt;
	private Statement statement;
	static ResultSet resultSet;
	
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,pwd);	
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public int insert_User(User user)
	{
		
		
		try
		{
			pstmt = connection.prepareStatement(INSERT);
			
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			
			x = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return x;
	}

	public List selectAll() 
	{
		try 
    	{
			statement = connection.createStatement();
			
			 resultSet = statement.executeQuery(FETCH_ALL);
			 
			 al = extractUserList(resultSet);
			
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			
		}
		
		return al;
	}


	public User selectSpecific(String email)
	{
		try {
	        
	        pstmt = connection.prepareStatement(FETCH_ONE);
	       
	        pstmt.setString(1, email);
	       
	        resultSet = pstmt.executeQuery();
	        
	        al = extractUserList(resultSet);
	        user = al.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return user;
	}

	public int DeleteUser(int id)
	{
		try 
		   {
			   pstmt = connection.prepareStatement(DELETE);
			   pstmt.setInt(1, id);
			   x = pstmt.executeUpdate();
		   } 
		   catch (Exception e)
		   {
			   e.printStackTrace();
		   }
		return x;
	}

	public int updateUser(String email, String password)
	{
		try 
		   {
			   pstmt = connection.prepareStatement(UPDATE);
			   pstmt.setString(1, password);
			   pstmt.setString(2, email);
			   x =  pstmt.executeUpdate();
			
		   } 
		   catch (Exception e)
		   {
			 e.printStackTrace();
		   }
		return x;
	}
	
	
	

	private ArrayList<User> extractUserList(ResultSet resultSet)
	{
		
		 try {
			while (resultSet.next()) 
			 {
			     al.add(new User(resultSet.getInt(1),resultSet.getString(2),
			    		 resultSet.getString(3),resultSet.getString(4),
			    		 resultSet.getString(5),resultSet.getString(6)));
				
			}
		}
		 catch (SQLException e)
		 {
			e.printStackTrace();
		}

		return al;
	}
	
	
	
	
	
	
	
	
	
}
	
