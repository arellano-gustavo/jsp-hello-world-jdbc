<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.appengine.hello.HelloInfo" %>

<%
	String user = request.getParameter("user");
	String password = request.getParameter("password");
	String aviso = "NO EXISTE";
	
	if(HelloInfo.getInstance().consulta(user, password)) {
	    aviso = "SI EXISTE";
	}
%>

<html>
  <head>
    <title>Procesa</title>
  </head>
  <body>
    usuario: <%= user %>
    <br/>
    password: <%= password %>
    <br/>
    <h1><%= aviso %></h1>
  </body>
</html>
