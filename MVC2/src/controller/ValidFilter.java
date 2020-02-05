package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class ValidFilter implements Filter 
{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		if(password.equals(password1))
		{
			chain.doFilter(request, response);
		}
		else
		{
			((HttpServletResponse) (response)).sendRedirect("/MVC2/Fail.html");
		}
	}


}
