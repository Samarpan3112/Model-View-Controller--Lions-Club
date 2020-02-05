package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;


public class Register extends HttpServlet 
{
		private boolean value;

		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			Model m=new Model();
			m.setName(request.getParameter("name"));
			m.setGender(request.getParameter("gender"));
			m.setUserid(request.getParameter("userid"));
			m.setPassword(request.getParameter("password"));
			String age2=request.getParameter("age");
			m.setAge(Integer.parseInt(age2));
			
			try
			{
			value=m.register();
			if(value==true)
			{
				response.sendRedirect("/MVC2/Success.html");
			}
			else
			{
				response.sendRedirect("/MVC2/Fail.html");
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
		}
		
}
