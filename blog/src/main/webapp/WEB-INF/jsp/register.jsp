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
    <title>Big eye博客注册页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="dao icon" href="../webapp/img/favicon.ico" type="image-x.icon"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css">
        .container{
            height: 100%;
            text-align: center;
            margin: 7% auto ;
        }
        body
        {
            background-image: url('../img/background03.jpg') ;
           background-repeat: no-repeat;
        }
</style>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('#ipwd').on('input propertychange', function() {
                    //input propertychange即实时监控键盘输入包括粘贴
                    var pwd = $.trim($(this).val());
                    //获取this，即ipwd的val()值，trim函数的作用是去除空格
                    var rpwd = $.trim($("#i2pwd").val());
                    if(rpwd!=""){
                        if(pwd==""&&rpwd==""){
                            //若都为空，则提示密码不能为空，为了用户体验（在界面上用required同时做了处理）
                            $("#msg_pwd").html("<font color='red'>密码不能为空</font>");
                        }
                        else{
                            if(pwd==rpwd){                                 //相同则提示密码匹配
                                $("#msg_pwd").html("<font color='green'>两次密码匹配通过</font>");
                                $("#btn_register").attr("disabled",false); //使按钮无法点击
                            }else{                                          //不相同则提示密码匹配
                                $("#msg_pwd").html("<font color='red'>两次密码不匹配</font>");
                                $("#btn_register").attr("disabled",true);
                            }
                        }}
                })
            })

        //由于是两个输入框，所以进行两个输入框的几乎相同的判断
        $(document).ready(function(){
            $('#i2pwd').on('input propertychange', function() {
                var pwd = $.trim($(this).val());
                var rpwd = $.trim($("#ipwd").val());
                if(pwd==""&&rpwd==""){
                    $("#msg_pwd").html("<font color='red'>密码不能为空</font>");
                }
                else{
                    if(pwd==rpwd){
                        $("#msg_pwd").html("<font color='green'>两次密码匹配通过</font>");
                        $("#btn_register").attr("disabled",false);
                    }else{
                        $("#msg_pwd").html("<font color='red'>两次密码不匹配</font>");
                        $("#btn_register").attr("disabled",true);
                    }
                }
            })
        })
    </script>
</head>
<body >
<div class="container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-offset-4 col-sm-4">
                <div class="form-group">
                    <h3 style="color: white;">Big Eye Blog Register</h3>
                        <br>
                </div>
            </div>
        </div>
        <div class="row ">
            <div class=" col-sm-offset-4 col-sm-4">
                <form role="form" method="POST" action="../insert/blog">
                    <div class="input-group">
                        <span class="input-group-addon">用&nbsp;&nbsp;户&nbsp;&nbsp;名</span>
                        <input type="text" class="form-control" name="username" required="required" placeholder="字母加数字组合" autofocus="autofocus">
                    </div>
                    <br>

                    <div class="input-group">
                        <span class="input-group-addon">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</span>
                        <input type="text" class="form-control" name="name" required="required" autofocus="autofocus">
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</span>
                        <input type="password" id="ipwd" class="form-control"  required="required" name="password">
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">确认密码</span>
                        <input type="password" id="i2pwd" class="form-control"  required="required" >

                    </div>
                    <p id="msg_pwd"></p>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">QQ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</span>
                        <input type="number" class="form-control" name="qq_number" required="required" autofocus="autofocus">
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</span>
                        <select name="sex" class="form-control">
                            <option value="男">女</option>
                            <option value="女">男</option>
                        </select>
                    </div>
                    <br>
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

                        <input type="submit" id="btn_register" class="btn btn-sm btn-success btn-block" value="Submit"></input>
                    </p>
                    <br>
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