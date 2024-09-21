package com.project.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.MenuDAO;
import com.project.DAOImpl.MenuDAOImpl;
import com.project.Model.Menu;

@WebServlet("/addMenu")
public class RegisterMenu extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		String itemName = req.getParameter("itemName");
		String description = req.getParameter("description");
		float price = Float.parseFloat(req.getParameter("price"));
		boolean isAvailable = Boolean.parseBoolean(req.getParameter("isAvailable"));
		String imgPath = req.getParameter("imgPath");
		
		Menu menu = new Menu(restaurantId,itemName,description,price,isAvailable,imgPath);
		MenuDAO menuDAO = new MenuDAOImpl();
		
		int x = menuDAO.insert(menu);
		
		if(x == 1)
		{
			resp.sendRedirect("success.html");
		}
		else 
		{
			resp.sendRedirect("failure.html");
		}
	}
		
}
