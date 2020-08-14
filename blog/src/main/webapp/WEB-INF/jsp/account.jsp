<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>大眼睛简易博客1.0</title>
	   <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <script type="text/javascript">
        function changepic() {
            $("#prompt3").css("display", "none");
            var reads = new FileReader();
            f = document.getElementById('file').files[0];
            reads.readAsDataURL(f);
            reads.onload = function(e) {
                document.getElementById('img3').src = this.result;
                $("#img3").css("display", "block");

            };
        }

    </script>
<style type="text/css">
    #img3 {
        height: 100%;
        width: 100%;
        border-radius: 50%;
    }
</style>
</head>
<body>

	<div id="wrapper" class="">
        <div class="overlay"></div>

        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Big Eye Blog 1.0
                    </a>
                </li>
                <li>

                    <a href="../action/reindex"><i class="fa fa-fw fa-home"></i> 首页</a>
                </li>
                <li>
                    <a href="../action/blog_list"><i class="fa fa-fw fa-folder"></i> 我的文章</a>
                </li>
                <li>
                    <a href="../action/write"><i class="fa fa-fw fa-file-o"></i> 写文章</a>
                </li>
                <li>
                    <a href="../action/account"><i class="fa fa-fw fa-cog"></i> 修改资料</a>
                </li>
                <li class="dropdown" style="display: none;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-plus"></i> Messages <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu" >
                        <li class="dropdown-header">history messages</li>
                        <li><a href="#">Comment</a></li>
                        <li><a href="#">Praise</a></li>
                        <li><a href="#">Guestbook</a></li>
                        <li><a href="#">Visitors</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
                <li >
                    <a href="../action/classInsert"><i class="fa fa-fw fa-bank"></i> 添加分类</a>
                </li>
                <li >
                    <a href="../action/labelInsert"><i class="fa fa-fw fa-bank"></i> 添加标签</a>
                </li>
                <li >
                    <a href="../action/class"><i class="fa fa-fw fa-dropbox"></i> 我的分类</a>
                </li>
                <li >
                    <a href="../action/blog_label"><i class="fa fa-fw fa-dropbox"></i> 我的标签</a>
                </li>
                <li>
                    <a href="../action/blog_message"><i class="fa fa-fw fa-twitter"></i> 我的留言</a>
                </li>
            </ul>
        </nav>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
          <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
          </button>
            <div class="container content col-sm-12">
               
                <div class="row ">
                    <div class=" col-sm-10 col-sm-offset-1  ">
                        <div class="panel panel-success ">
                            <div class=" panel-heading">
                                <span class="panel-title">My Account</span>
                                 
                            </div>
                        <div class=" panel-body">
                           <br>

                           <form role="form" action="../insert/account" method="post" enctype="multipart/form-data">

                            <div class="input-group" style="width: 100%;" >
                                      <input type="file" id="file"  name="file" onchange="changepic(this)" value="${blog.logo}" accept="image/jpg,image/jpeg,image/png,image/PNG">
                                         <!--当vaule值改变时执行changepic函数，规定上传的文件只能是图片-->
                                <div style="position: relative;border: 5px solid lightblue;width: 100px;height:100px;margin: 5px auto;border-radius: 50%;">
                                    <img src="${blog.logo}" id="img3" />

                                </div>


                               </div><br>


                               <div class="input-group">
                                   <span class="input-group-addon">账号</span>
                                   <input type="text" name="username" value="${blog.username}" readonly="readonly" class="form-control">
                               </div><br>
                               <div class="input-group">
                                   <span class="input-group-addon">密码</span>
                                   <input type="password" name="passwd" value="${blog.passwd}" required="required" class="form-control">
                               </div><br>

                              
                                <div class="input-group">
                                   <span class="input-group-addon">昵称</span>
                                   <input type="text" name="name" value="${blog.name}"  class="form-control" required="required">
                               </div><br>
                               <div class="input-group">
                                   <span class="input-group-addon">签名</span>
                                   <input type="text" name="sign" value="${blog.sign}"  class="form-control">
                               </div><br>
                               <div class="input-group">
                                   <span class="input-group-addon">性别</span>
                                   <select name="sex" class="form-control">
                                       <option value="${blog.sex}">${blog.sex}</option>
                                       <option value="男">男</option>
                                       <option value="女">女</option>
                                   </select>
                               </div><br>
                               <div class="input-group">
                                   <span class="input-group-addon">兴趣</span>
                                   <input type="text" name="interest" value="${blog.interest}"  class="form-control" required="required">
                               </div><br>

                                <div class="input-group">
                                   <span class="input-group-addon">QQ</span>
                                   <input type="number" name="qq_number" value="${blog.qq_Number}"  class="form-control" required="required">
                               </div>

                               <br>
                               <p>

                                   <input type="submit" class="btn btn-sm btn-success btn-block" value="Submit"></input>
                               </p>

                           </form>

               
                        </div>

                    <div class="panel-footer">
                       <p class="text-primary" style="text-align:center;">Copyright 大眼睛 Design By Wolf VX:a815193474</p>
                        <p class="text-primary" style="text-align:center;"><a rel="nofollow" href="http://www.beian.miit.gov.cn" target="_blank">陇ICP备19003156号</a></p>

                    </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
	
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
		  var trigger = $('.hamburger'),
		      overlay = $('.overlay'),
               content = $('.content'),
		     isClosed = true;

		    trigger.click(function () {
		      hamburger_cross();      
		    });

		    function hamburger_cross() {

		      if (isClosed == true) {          
		        overlay.hide();
		        trigger.removeClass('is-closed');
		        trigger.addClass('is-open');
                content.removeClass('col-sm-12')
                content.addClass('col-sm-10')
		        isClosed = false;
		      } else {   
		        overlay.show();
		        trigger.removeClass('is-open');
		        trigger.addClass('is-closed');
                 content.removeClass('col-sm-10')
                content.addClass('col-sm-12')
		        isClosed = true;
		      }
		  }
		  
		  $('[data-toggle="offcanvas"]').click(function () {
		        $('#wrapper').toggleClass('toggled');
		  });  
		});
	</script>
</body>
</html>