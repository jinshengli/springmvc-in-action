
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="static/js/jquery-3.4.1.js"> </script>

    <title>Insert title here</title>
</head>
<body>

    <img src="static/image/1.jpg">

    <form action="stu/register.do" method="get">
        <input type="text" name="name" value="ljs">
        <input type="text" name="age" value="23">
        <input type="submit" value="get 请求">
    </form>

    <form action="stu/login.do" method="post">
        <input type="text" name="name" value="ljs">
        <input type="text" name="age" value="23">
        <input type="submit" value="post 请求">
    </form>

    <form action="stu/param.do" method="post">
        <input type="text" name="rname" value="ljs">
        <input type="text" name="rage" value="23">
        <input type="submit" value="请求参数不一样，使用@RequestParam; 默认请求参数必要">
    </form>

    <form action="stu/getParamByObject.do" method="post">
        <input type="text" name="name" value="ljs">
        <input type="text" name="age" value="23">
        <input type="submit" value="使用vo对象接收参数。">
    </form>

    <hr/>

    <h2>返回数据处理</h2>

    <a href="obj/list.do">list 视图</a> <br>

    <a href="obj/void.do">通过response返回 [void] </a>  <br>

    <input id="ajx1" type="button" value="ajax . post . void ">

    <hr>

    <h3> 以下返回 json类型对象 Ajax 请求</h3>

    <button id="getStudent" type="button">获取一个studentVo</button> <br>

    <button id="getListStudent" type="button">获取一个studentVo List</button> <br>


    <button id="getString" type="button">Ajax 获取一个String</button> <br>


    <script type="text/javascript">
        $(function () {
            $("#ajx1").click(function () {
                $.ajax({
                    url:"obj/objJson.do",
                    data:{"name":"李金胜", age:"23"},
                    type:"post",
                    dataType:"json",
                    success:function (resp) {
                        alert(resp);
                        alert(JSON.stringify(resp));
                        $("#ajax1").html(resp.name + resp.age);
                    }
                })
            });


            $("#getStudent").click(function () {
                $.ajax({
                    url:"json/student.do",
                    type:"get",
                    success:function (resp) {
                        alert(resp);
                        alert(resp.name + "  " + resp.age);
                    }
                })
            });

            $("#getListStudent").click(function () {
                $.ajax({
                    url:"json/listStudent.do",
                    type:"get",
                    success:function (resp) {
                        $.each(resp, function (i, data) {
                            alert("name: " + data.name + " age: " + data.age);
                        })
                    }
                })
            });

            $("#getString").click(function () {
                $.ajax({
                    url:"json/string.do",
                    type:"get",
                    success:function (resp) {
                        alert(resp)
                    }
                })
            })
        })



    </script>


</body>
    







</html>
