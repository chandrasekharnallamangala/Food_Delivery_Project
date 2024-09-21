package com.project.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.UserDAO;
import com.project.DAOImpl.UserDAOImpl;


@WebServlet("/resetPassword")
public class ResetPassword extends HttpServlet
{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirm_password = req.getParameter("confirm_password");
		
		if(password.equals(confirm_password))
		{
			UserDAO userDAOImpl = new UserDAOImpl();
			int x = userDAOImpl.updateUser(email, confirm_password);
			if(x == 0)
			{
				resp.sendRedirect("failure.html");
			}
			else 
			{
				resp.sendRedirect("success.html");	
			}
		}
		
		else
		{
			resp.sendRedirect("failure.html");
		}
		
		
		
		
		
	}

}
