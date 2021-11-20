<%--
  Created by IntelliJ IDEA.
  User: 范
  Date: 2021/11/10
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>--%>
<% String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    request.setAttribute("url", url);

%>
<base href="${requestScope.url}">

<link type="text/css" rel="stylesheet" href="static/css/style.css">

<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>

