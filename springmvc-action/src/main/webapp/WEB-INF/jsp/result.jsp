<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>result</title>
</head>
<body>
    <h5>result页面</h5>
    <h2>${url}</h2>
    <h3> name = ${name} </h3>
    <h3> age = ${age} </h3>
</body>


</html>
