<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>下载文件列表</title>
</head>
<body>

    <ul>
        <c:forEach items="${list}" var="file" >
            <li>
                <a href="/download?file=${file}">${file}</a>
            </li>
        </c:forEach>
    </ul>

    <h2> 第二种下载方式 2 </h2>

    <ul>
        <c:forEach items="${list}" var="file" >
            <li>
                <a href="/download1?file=${file}">${file}</a>
            </li>
        </c:forEach>
    </ul>


    <h2> 第3种下载方式 3 </h2>

    <ul>
        <c:forEach items="${list}" var="file" >
            <li>
                <a href="/download1?file=${file}">${file}</a>
            </li>
        </c:forEach>
    </ul>


</body>
</html>
