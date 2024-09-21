package com.project.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.project.DAO.OrderHistoryDAO;
import com.project.Model.OrderHistory;

public class OrderHistoryDAOImpl implements OrderHistoryDAO
{
	int x = -1;
	ArrayList<OrderHistory> al = new ArrayList();
	private	static final String INSERT = "INSERT INTO order_history(user_id,order_id,total,status) VALUES(?,?,?,?)";
	private static final String FETCH_ONE  = "Select * from order_history where user_id = ?";
	private static final String UPDATE_STATUS = "UPDATE order_history SET status = CASE WHEN status = true THEN false ELSE true END WHERE order_hist_id = ?";

	
	
	static String url= "jdbc:mysql://localhost:3306/project_db";
	static String username = "root";
	static String pwd = "SYSTEM";
	
	OrderHistory orderHistory;
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
	
	

	public int insertOrderHistory(OrderHistory oh)
	{

		try
		{
			pstmt = connection.prepareStatement(INSERT);
			
			pstmt.setInt(1, oh.getUser_id());
			pstmt.setInt(2, oh.getOrder_id());
			pstmt.setInt(3, oh.getTotal());
			pstmt.setBoolean(4, oh.getStatus());
			
			
			x = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return x;
		
		
	}

	public OrderHistory fetchOrderOnUserId(int user_id) 
	{
try {
	        
	        pstmt = connection.prepareStatement(FETCH_ONE);
	       
	        pstmt.setInt(1, user_id);
	       
	        resultSet = pstmt.executeQuery();
	        
	        al = extractUserList(resultSet);
	        orderHistory = al.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return orderHistory;
		
		
	}

	public int updateHistory(int orderHistoryId)
	{
		

		try
		{
			pstmt = connection.prepareStatement(UPDATE_STATUS);
			pstmt.setInt(1, orderHistoryId);
		    x =	pstmt.executeUpdate();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
	private ArrayList<OrderHistory> extractUserList(ResultSet resultSet)
	{
		
		 try {
			while (resultSet.next()) 
			 {
			     al.add(new OrderHistory(resultSet.getInt(1),resultSet.getInt(2),
			    		 resultSet.getInt(3),resultSet.getString(4),
			    		 resultSet.getInt(5),resultSet.getBoolean(6)));
				
			}
		}
		 catch (SQLException e)
		 {
			e.printStackTrace();
		}

		return al;
	}
	

}
