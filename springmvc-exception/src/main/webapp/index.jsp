<%--
  Created by IntelliJ IDEA.
  User: ljs
  Date: 2020/6/22
  Time: 7:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
</head>
<body>


    <a href="exception">这是一个name异常测试</a><br>
    <a href="ageException">这是一个age异常测试</a><br>

</body>
</html>
