
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>list result</title>

    <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>

</head>

<body>

    <div align="center">

        <p> 学生页面 </p><br>
        <table id="tb">

        </table>




    </div>

    <script type="text/javascript">
        $(function () {
            getStudentInfo();

            function getStudentInfo() {
                $.ajax({
                    url:"stu/getStudentList",
                    dataType:"json",
                    success:function (resp) {
                        $.each(resp, function (i, item) {
                            $("#tb")
                                .append("<tr>")
                                .append("<td>" + item.id + "</td>")
                                .append("<td>" + item.name + "</td>")
                                .append("<td>" + item.age + "</td>")
                                .append("</tr>");
                        });
                    }
                })
            }
        })
    </script>

</body>


</html>
