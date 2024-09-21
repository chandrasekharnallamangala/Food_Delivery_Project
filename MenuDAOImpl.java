package com.project.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.DAO.MenuDAO;
import com.project.Model.Menu;

public class MenuDAOImpl implements MenuDAO
{
	ArrayList<Menu> al = new ArrayList<Menu>();
	int x = -1;
	static String url= "jdbc:mysql://localhost:3306/project_db";
	static String username = "root";
	static String pwd = "SYSTEM";
	
	
	private static final String INSERT = "Insert into menu(restaurant_id,item_name,description,price,isavailable,imgpath) values(?,?,?,?,?,?)";
	private static final String FETCH_MENU = "SELECT item_name FROM menu WHERE menu_id = ?";
	private static final String DELETE_ITEM = "delete from menu where menu_id = ? ";
	private static final String UPDATE_STATUS = "UPDATE menu SET isAvailable = CASE WHEN isAvailable = true THEN false ELSE true END WHERE menu_id = ?";
	private static final String FETCH_ITEM = "SELECT item_name FROM menu WHERE restaurant_id = ?";
	
	
	
	Menu menu;
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

	public int insert(Menu menu)
	{
		
		try
		{
			pstmt = connection.prepareStatement(INSERT);
			
			pstmt.setInt(1,menu.getRestaurant_id());
			pstmt.setString(2,menu.getItem_name());
			pstmt.setString(3, menu.getDescription());
			pstmt.setFloat(4,menu.getPrice());
			pstmt.setBoolean(5, menu.getIsAvailable());
			pstmt.setString(6, menu.getImgPath());
			
		x =	pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		return x;
		
	}

	public List<Menu> get_All_Menus(int rest_id) {
	    try {
	        pstmt = connection.prepareStatement(FETCH_ITEM); // Update the query to FETCH_ITEM, which is based on restaurant_id
	        pstmt.setInt(1, rest_id); // Pass the restaurant_id parameter

	        resultSet = pstmt.executeQuery(); // Execute the query with the parameter
	        
	        al = extractMenuList(resultSet); // Correctly process the resultSet and return the menu items
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return al;
	}


	public List<Menu> get_Menu_By_Id(int id)
	{
		 try {
		        pstmt = connection.prepareStatement(FETCH_MENU); // Update the query to FETCH_ITEM, which is based on restaurant_id
		        pstmt.setInt(1, id); // Pass the restaurant_id parameter

		        resultSet = pstmt.executeQuery(); // Execute the query with the parameter
		        
		        al = extractMenuList(resultSet); // Correctly process the resultSet and return the menu items
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return al;
	}

	public int delete_By_Id(int id)
	{
		try
		{
			pstmt = connection.prepareStatement(DELETE_ITEM);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}

	public int update_By_Id(int id)
	{
		try
		{
			pstmt = connection.prepareStatement(UPDATE_STATUS);
			pstmt.setInt(1, id);
		    x =	pstmt.executeUpdate();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	
	private ArrayList<Menu> extractMenuList(ResultSet resultSet) {
	    ArrayList<Menu> menuList = new ArrayList<Menu>();
	    
	    try {
	        while (resultSet.next()) {
	            menuList.add(new Menu(resultSet.getString("item_name"))); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return menuList;
	}

	
	

}
