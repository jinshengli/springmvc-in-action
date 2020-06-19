
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
</head>
<body>

    <a href="stu/list.do"> 点击 list.do </a>
    <a href="test/some.do"> 点击some </a>
    <a href="test/doOther.do"> other </a>

</body>
</html>
