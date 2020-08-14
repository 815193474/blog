<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession sess = request.getSession();
    String message = (String)sess.getAttribute("mes");

    if(message == ""||message == null){

    }else{
%>
<script type="text/javascript">
    alert("<%=message %>");
</script>
<%
        sess.setAttribute("mes", "");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Big eye博客登录页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="dao icon" href="../img/favicon.ico" type="image-x.icon"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css">
        .container{
            height: 100%;
            text-align: center;
            margin: 14% auto ;
        }
        body
        {
            background-image: url('../img/background07.jpg') ;
        }
    </style>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body >
<div class="container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-offset-4 col-sm-4">
                <div class="form-group">
                    <h3 style="color: white;">Big Eye Blog Login</h3>
                            <br>

                </div>
            </div>
        </div>
        <div class="row ">
            <div class=" col-sm-offset-4 col-sm-4">
                <form role="form" method="POST" action="../login/blog">
                    <div class="input-group">
                        <span class="input-group-addon">用&nbsp;&nbsp;户&nbsp;&nbsp;名</span>
                        <input type="text" class="form-control" name="username" required="required" autofocus="autofocus">
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</span>
                        <input type="password" class="form-control"  required="required" name="password">
                    </div>
                    <br>
                    <div class="input-group ">

                        <img  src="${pageContext.request.contextPath}/util/u"  id="validateCodeImg" onclick="changeImg()">


                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">验证码</span>
                        <input type="text" name="yan" class="form-control" required="required" placeholder="请输入验证码">
                    </div>
                    <br>
                    <p>

                        <input type="submit" class="btn btn-sm btn-success btn-block" value="Login"></input>
                    </p>
                    <br>
                    <div class="input-group">
                        <span style="width: 100px;height: 30px;color: white;">没有账号？<a style="cursor:pointer;text-decoration: none;" href="../action/register">点击注册</a></span>

                    </div>
                    <br>

                    <div class="input-group pull-center center-block">

                        <span class="help-block"><p style="color: white;">Copyright © VX:a815193474</p></span>
                        <p class="text-primary" style="text-align:center;"><a rel="nofollow" href="http://www.beian.miit.gov.cn" target="_blank">陇ICP备19003156号</a></p>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    function changeImg() {
        document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/util/u?"+Math.random();
        //在末尾加Math.random()的作用：<br>如果两次请求地址一样，服务器只会处理第一次请求，第二次请求返回内容和第一次一样。或者说如果地址相同，第一次请求时，将自动缓存，导致第二次不会重复请求了。Math.random()是调用javascript语法中的数学函数，能够产生随机数。<br>末尾加Math.random()使每次请求地址不相同，服务器每次都去做不同的响应。也可以使用new date()时间戳的形式作为参数传递。
    }
</script>
</html>