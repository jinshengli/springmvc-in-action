<%--
  Created by IntelliJ IDEA.
  User: ljs
  Date: 2020/6/18
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Some</title>
</head>
<body>

    <h5>Some</h5>

    <h2>Request域中的name: ${name}</h2> <br>

    <h2>url上的参数age：${param.age}</h2>


</body>
</html>
