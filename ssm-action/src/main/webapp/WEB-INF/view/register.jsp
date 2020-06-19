<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>
    <title>register</title>
</head>
<body>


    <div align="center">
        <span>注册页面</span>

        <form action="stu/addStudent" method="post">
            姓名： <input name="name" type="text" id="name"><br>
            年龄：<input type="text" name="age" id="age"><br>
            <input type="submit" value="注册">
        </form>

    </div>

    <script>


    </script>

</body>
</html>
