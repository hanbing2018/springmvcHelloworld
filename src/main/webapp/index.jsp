<%--
  Created by IntelliJ IDEA.
  User: hanbing
  Date: 2019/9/6
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>helloworld</title>

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"user/user",
                    type:"post",
                    contentType:"application/json;charset=utf-8",
                    dataType:"json",
                    data:'{"username":"孙悟空","password":"65554938534"}',
                    success:function (data) {
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.money);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <h3>首页</h3>

    <a href="${ pageContext.request.contextPath }/user/interceptor">testInterceptor</a>
    <br>
    <a href="${ pageContext.request.contextPath }/user/exception">testException</a>
    <br>

    <form action="user/upload" method="post" enctype="multipart/form-data">
        选择文件<input type="file" name="upload"><br>
        <input type="submit" value="提交">
    </form>

    <br>
    <button id="btn">点击</button>

    <a href="${ pageContext.request.contextPath }/user/modelAndView">testModelAndView</a>
    <br>
    <a href="${ pageContext.request.contextPath }/user/response">testResponse</a>
    <br>
    <a href="${ pageContext.request.contextPath }/user/DELsessionAttribute">testDELsessionAttribute</a>
    <br>
    <a href="${ pageContext.request.contextPath }/user/sessionAttribute">testSessionAttribute</a>
    <br>
    <a href="${ pageContext.request.contextPath }/user/modelAttribute?username=孙悟空">testModelAttribute</a>
    <br>
    <a href="${ pageContext.request.contextPath }/user/cookievalue">testCookievalue</a>
    <br>
    <a href="${ pageContext.request.contextPath }/user/requestheader">testRequestheader</a>
    <br>
    <a href="${ pageContext.request.contextPath }/user/helloWorld/10">testPathVariable</a>
    <br>
    <form action="user/user" method="post">
        <%--姓名<input type="text" name="username"/><br>--%>
        密码<input type="text" name="password"/><br>
        mondy<input type="text" name="money"/><br>
        <br>
        街道1<input type="text" name="list[0].street"/><br>
        楼房1<input type="text" name="list[0].build"/><br>
        日期<input type="text" name="list[0].date"/>
        <input type="submit" value="提交">
    </form>

</body>
</html>
