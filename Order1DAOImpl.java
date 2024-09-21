package com.project.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.project.DAO.Order1DAO;
import com.project.Model.Order1;

public class Order1DAOImpl implements Order1DAO
{
	ArrayList<Order1> al = new ArrayList<Order1>();
	int x=-1;
	private	static final String INSERT = "INSERT INTO order1(user_id,restaurant_id,total_amount,status,payment_op) VALUES(?,?,?,?,?)";
	private static final String FETCH_ONE  = "Select * from order1 where order_id = ?";
	private static final String UPDATE_STATUS = "UPDATE order1 SET status = CASE WHEN status = true THEN false ELSE true END WHERE order_id = ?";
	
	
	static String url= "jdbc:mysql://localhost:3306/project_db";
	static String username = "root";
	static String pwd = "SYSTEM";
	
	
	
	Order1 order1;
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
	
	
	
	
	
	
	public int insertOrders(Order1 order)
	{
		try
		{
			pstmt = connection.prepareStatement(INSERT);
			pstmt.setInt(1, order.getUser_id());
			pstmt.setInt(2, order.getRestaurant_id());
			pstmt.setInt(3, order.getTotal_amount());
			pstmt.setBoolean(4, order.getStatus());
			
			pstmt.setString(5, order.getPayment_op());
			
			x = pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return x ;
	}
	
	
	
	public Order1 fetchOrderId(int orderId)
	{
		try {

			pstmt = connection.prepareStatement(FETCH_ONE);

			pstmt.setInt(1, orderId);

			resultSet = pstmt.executeQuery();

			al = extractUserList(resultSet);
			order1 = al.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return order1;
	}

	
	public int updateOrder(int orderId)
	{
		try
		{
			pstmt = connection.prepareStatement(UPDATE_STATUS);
			pstmt.setInt(1, orderId);
		    x =	pstmt.executeUpdate();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
	private ArrayList<Order1> extractUserList(ResultSet resultSet)
	{
		
		 try {
			while (resultSet.next()) 
			 {
			     al.add(new Order1(resultSet.getInt(1),resultSet.getInt(2),
			    		 resultSet.getInt(3),resultSet.getInt(4),
			    		 resultSet.getBoolean(5),resultSet.getString(6),resultSet.getString(7)));
				
			}
		}
		 catch (SQLException e)
		 {
			e.printStackTrace();
		}

		return al;
	}
	
	
}
