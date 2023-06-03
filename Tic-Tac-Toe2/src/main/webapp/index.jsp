<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Tic-tac-toe</title>
</head>
<body>
<% if (session.getAttribute("user") != null) {
    response.sendRedirect(request.getContextPath() + "/success.jsp");
    }
%>
<form action="Login" method="post">
    Enter username : <input type="text" name="username"> <BR>
    Enter password : <input type="password" name="password"> <BR>
    <input type="submit" value="Login"/>
</form>
</body>
</html>