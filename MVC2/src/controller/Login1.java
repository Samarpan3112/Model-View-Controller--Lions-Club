package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;


public class Login1 extends HttpServlet 
{
		private HttpSession session;

		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			Model m = new Model();
			m.setUserid(request.getParameter("userid"));
			m.setPassword(request.getParameter("password"));
			
			try
			{
			boolean value=m.login();
			if(value==true)
			{
				session=request.getSession(true);
				session.setAttribute("name", m.getName());
				response.sendRedirect("/MVC2/LoginSuccess.jsp");
			}
			else
			{
				response.sendRedirect("/MVC2/LoginFail.html");
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	
}
