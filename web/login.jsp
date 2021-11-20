
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/JavaWeb_war_exploded/loginServlet1" method="get">
    用户名:<input type="text" name="username" value="${cookie.username.value}">
    密码:<input type="password" name="password" value="" >
    <input type="submit">登录
</form>
</body>
</html>
