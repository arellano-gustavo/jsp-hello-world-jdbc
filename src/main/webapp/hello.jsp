<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <link href='//fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
</head>
<body>
  <h2>Hello!!!</h2>
  <form action="procesa.jsp" method="post">
  <table>
    <tr>
      <td>User:</td>
      <td><input name="user" type="text"/></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input name="password" type="password" /></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="login"/></td>
    </tr>
  </table>
  </form>
</body>
</html>
