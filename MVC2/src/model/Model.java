package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String user="system";
	String pwd="samar";
	String sql="INSERT INTO LIONSCLUB VALUES(?,?,?,?,?)";
	private String name;
	private int age;
	private String gender;
	private String userid;
	private String password;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	public String getUserid() 
	{
		return userid;
	}
	public void setUserid(String userid) 
	{
		this.userid = userid;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Model()
	{
		try
		{
		DriverManager.registerDriver(new OracleDriver());
		con=DriverManager.getConnection(url, user, pwd);
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public boolean register()throws SQLException
	{
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
		pstmt.setString(3, gender);
		pstmt.setString(4, userid);
		pstmt.setString(5, password);
		int row=pstmt.executeUpdate();
		
		if(row==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean login() throws SQLException
	{
		String sql="SELECT NAME FROM LIONSCLUB WHERE USERID=? AND PASSWORD=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, userid);
		pstmt.setString(1, password);
		res=pstmt.executeQuery();
		if(res.next()==true)
		{
			name=res.getString(1);
			return true;
		}
		else
		{
			return false;
		}
	}

}
