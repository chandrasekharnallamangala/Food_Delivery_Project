package com.project.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.UserDAO;
import com.project.DAOImpl.UserDAOImpl;
import com.project.Model.User;


@WebServlet("/addUser")
public class RegisterUser extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{ 
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		
	   User user = new User( username, password, email, address, role);  
	   UserDAO userDAO = new UserDAOImpl();
	   int x = userDAO.insert_User(user);
	   
	   if(x == 0)
	   {
		   resp.sendRedirect("failure.html");
	   }
	   
	   else 
	   {
		 resp.sendRedirect("success.html");
	   }
	}

}
