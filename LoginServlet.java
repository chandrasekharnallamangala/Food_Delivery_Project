package com.project.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.project.DAO.UserDAO;
import com.project.DAOImpl.UserDAOImpl;
import com.project.Model.User;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet 
{
	
	private HttpSession session;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDAO userDAO = new UserDAOImpl();
	    User user  =  userDAO.selectSpecific(email);
	   
	    if(user == null)
	    {
	    	resp.sendRedirect("register.jsp");
	    }
	    else
	    {
	    	if(password.equals(user.getPassword()))
	    	{
	    		
	    		
	    		session = req.getSession();
	    		session.setAttribute("user_name", user.getUser_name());
	    		resp.sendRedirect("welcome.jsp");
	    		
	    	}
	    	 
	    	else
	    	{
				resp.sendRedirect("failure.html");
			}
		}
	}

}
