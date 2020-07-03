<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>ajax 表单文件上传</title>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>

    <script>

       $(function () {

           $("#importActivityBtn").click(function () {

               //发送请求
               //FormData是ajax定义的接口,可以模拟键值对向服务器提交数据
               //FormData类型的作用是可以提交文本数据,还可以提交二进制数据.
               var formData = new FormData();
               formData.append("file", $("#activityFile")[0].files[0]);
               $.ajax({
                   url: 'form3',
                   data: formData,
                   type: 'post',
                   processData: false,//主要是配合contentType使用的,默认情况下,ajax把所有数据进行applciation/x-www-form-urlencoded编码之前,会把所有数据统一转化为字符串;把proccessData设置为false,可以阻止这种行为.
                   contentType: false,//默认情况下,ajax向服务器发送数据之前,把所有数据统一按照applciation/x-www-form-urlencoded编码格式进行编码;把contentType设置为false,能够阻止这种行为.
                   success: function (data) {
                       if (data.success) {
                           alert("上传成功");
                       } else {
                           alert("失败")
                       }
                   }
               })
           })



       })

    </script>

</head>
<body>


<div class="modal-body" style="height: 350px;">

    <div style="position: relative;top: 20px; left: 50px;">
        请选择要上传的文件：<small style="color: gray;">[仅支持.xls或.xlsx格式]</small>
    </div>

    <div style="position: relative;top: 40px; left: 50px;">
        <input type="file" id="activityFile">
        <button id="importActivityBtn" type="button" class="btn btn-primary">导入</button>
    </div>




</div>


</body>
</html>
