<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>LOGIN SUCCESSFUL</title>
</head>
<body>
<%
session=request.getSession();
out.println(session.getAttribute("name"));
%>

</body>
</html>