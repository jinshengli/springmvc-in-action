
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

    <a href="redirect.do">我的redirect请求</a><br>

    <a href="redirect1.do">我的redirect1请求</a><br>

    <a href="redirect2.do">我的redirect2请求</a><br>

    <h2>以下是对请求做转发</h2>

    <a href="doDispact.do">转发请求00</a><br>

    <a href="doDispact1.do">转发请求01</a><br>

    <a href="doDispact2.do">转发请求02</a><br>


</body>
</html>
