package com.project.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.project.Model.Restaurant;
import com.project.DAO.RestaurantDAO;

public class RestaurantDAOImpl implements RestaurantDAO
{
	
	ArrayList al = new ArrayList();
	private static final String INSERT ="insert into restaurant(name,cuisine_type,delivery_time,isactive,rating,imgpath) values(?,?,?,?,?,?)";
	private static final String FETCHALL = "Select * from restaurant";
	private static final String FETCH_ONE = "select * from restaurant where restaurant_id = ?";
	private static final String UPDATE = "UPDATE restaurant SET isActive = CASE WHEN isActive = true THEN false ELSE true END WHERE restaurant_id = ?";
	private static final String DELETE = "Delete from restaurant where Restaurant_id = ?";

	
	int x = -1;
	static String url= "jdbc:mysql://localhost:3306/project_db";
	static String username = "root";
	static String pwd = "SYSTEM";
	
	Restaurant restaurant;
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

	public int insert_Data(Restaurant rest)
	{
		try
		{
			pstmt = connection.prepareStatement(INSERT);
			
			pstmt.setString(1,rest.getName());
			pstmt.setString(2,rest.getCuisine_type());
			pstmt.setInt(3, rest.getDelivery_Time());
			pstmt.setBoolean(4,rest.getIsActive());
			pstmt.setInt(5, rest.getRating());
			pstmt.setString(6, rest.getImgPathString());
			
		x =	pstmt.executeUpdate();
		}
		catch (Exception e)
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
			   resultSet = statement.executeQuery(FETCHALL);
			   
			   al = extractUserList(resultSet);
			   
			   
			
	       } 
		   catch (Exception e)
		   {
			 e.printStackTrace();
		   }
		 
		 return al;
	   }
		

	private ArrayList<Restaurant> extractUserList(ResultSet resultSet)
	{
		try {
			while (resultSet.next()) 
			 {
			     al.add(new Restaurant(resultSet.getInt(1),resultSet.getString(2),
			    		 resultSet.getString(3),resultSet.getInt(4),
			    		 resultSet.getBoolean(5),resultSet.getInt(6),resultSet.getString(7)));
				
			}
		}
		 catch (SQLException e)
		 {
			e.printStackTrace();
		}

		return al;
	}



	public Restaurant fetch_By_Id(int id)
	{

		try { 
	        pstmt = connection.prepareStatement(FETCH_ONE);
	       
	        pstmt.setInt(1, id);
	       
	        resultSet = pstmt.executeQuery();
	        
	        al = extractUserList(resultSet);
	        restaurant = (Restaurant) al.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return restaurant;
		
	}

	public int update_By_Id(int id)
	{
		 try
		   {
			   pstmt = connection.prepareStatement(UPDATE);
			   pstmt.setInt(1, id);
			   
			  x =  pstmt.executeUpdate();
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		return x;
	}

	public int delete_BY_Id(int id)
	{
		
		try
		  {
			  pstmt = connection.prepareStatement(DELETE);
			  pstmt.setInt(1, id);
			  x = pstmt.executeUpdate();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		return x;
	}
	
	
	
	
}
