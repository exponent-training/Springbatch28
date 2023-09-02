<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome In Application</h1>

<%String str = (String) request.getAttribute("msg"); %>
<%if(str != null){ %>
  <span style="color: red;"><%out.print(str); %></span>
<%} %>

<form action="log">
   Username : <input type="text" name="uname"><br><br>
   Password : <input type="password" name="pass"><br><br>
   
   <input type="submit" value="Login">&nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp">Register Here</a>
</form>
</body>
</html>