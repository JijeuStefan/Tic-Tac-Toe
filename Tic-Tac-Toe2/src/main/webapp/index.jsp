<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Tic-tac-toe</title>
    <link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
    <%
        session = request.getSession(true);
        if (session.getAttribute("user") != null) {
        response.sendRedirect(request.getContextPath() + "/success.jsp");
        }
    %>
    <div class="login-box">
        <form action="Login" method="post">
            <h2>Login</h2>
            <div class="user-box">
                <input type="text" name="username" required="" autocomplete="off">
                <label>Username</label>
            </div>
            <div class="user-box">
                <input type="password" name="password" required="">
                <label>Password</label>
            </div>
            <input class="submit" type="submit" value="Login"/>
        </form>
    </div>
</body>
</html>