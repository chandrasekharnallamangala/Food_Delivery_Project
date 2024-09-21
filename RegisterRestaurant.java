package com.project.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.RestaurantDAO;
import com.project.DAOImpl.RestaurantDAOImpl;
import com.project.Model.Restaurant;


@WebServlet("/addRestaurant")
public class RegisterRestaurant extends HttpServlet
{


	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String restaurantName = req.getParameter("restaurantName");
		String cuisineType = req.getParameter("cuisineType");
		int deliveryTime = Integer.parseInt(req.getParameter("deliveryTime"));
		boolean isActive    = Boolean.parseBoolean(req.getParameter("isActive"));
		int rating = Integer.parseInt(req.getParameter("rating"));
		String imgPath = req.getParameter("imgPath");
		
		Restaurant restaurant = new Restaurant(restaurantName,cuisineType,deliveryTime,isActive,rating,imgPath);
		RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
		
		int x =  restaurantDAO.insert_Data(restaurant);
		if(x == 0)
		{
			resp.sendRedirect("fsilure.html");
		}
		else 
		{
			resp.sendRedirect("success.html");
		}
		
	}
}


