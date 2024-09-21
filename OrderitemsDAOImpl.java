package com.project.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.project.DAO.OrderItemsDAO;
import com.project.Model.OrderItems;

public class OrderitemsDAOImpl implements OrderItemsDAO
{
	int x = -1;
	ArrayList<OrderItems> al = new ArrayList();
	
	private	static final String INSERT = "INSERT INTO order_items(order_id, menu_id,quantity ,sub_total) VALUES(?,?,?,?)";
	private static final String FETCH_ONE  = "Select * from order_items where order_id = ?";

	
	static String url= "jdbc:mysql://localhost:3306/project_db";
	static String username = "root";
	static String pwd = "SYSTEM";
	
	OrderItems orderItems;
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


	public int insertOrderItems(OrderItems orderItems)
	{
		
		try
		{
			pstmt = connection.prepareStatement(INSERT);
			
			pstmt.setInt(1, orderItems.getOrder_id());
			pstmt.setInt(2, orderItems.getMenu_id());
			pstmt.setInt(3, orderItems.getQuantity());
			pstmt.setInt(4, orderItems.getSub_total());
			
			
			x = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return x;
		
		
	}


	public OrderItems fetchOrderItems(int order_id)
	{
		try {

			pstmt = connection.prepareStatement(FETCH_ONE);

			pstmt.setInt(1, order_id);

			resultSet = pstmt.executeQuery();

			al = extractUserList(resultSet);
			orderItems = al.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return orderItems;
		
	}
	

	private ArrayList<OrderItems> extractUserList(ResultSet resultSet)
	{
		
		 try {
			while (resultSet.next()) 
			 {
			     al.add(new OrderItems(resultSet.getInt(1),resultSet.getInt(2),
			    		 resultSet.getInt(3),resultSet.getInt(4),
			    		 resultSet.getInt(5)));
				
			}
		}
		 catch (SQLException e)
		 {
			e.printStackTrace();
		}

		return al;
	}
	
	
}
