<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
                    <div class="panel panel-primary ">
                        <div class=" panel-heading">
                            <span class="panel-title">我的分类</span>

                        </div>
                        <div class=" panel-body">
                           <div style="padding:5px 10px;">
                               <c:forEach items="${classify}" var="classify">
                               <span class="pull-left">${classify.name}</span>
                               <span class="pull-right"><a class="btn btn-xs btn-danger" href="../delete/classify?id=${classify.id}">删除</a></span><br><br>
                               </c:forEach>
                           </div>

                           <!-- <ul class="pagination pull-right">
                            <li> <a  href="###"  type="text/html">&laquo;</a> </li>

                            <li> <a  href="###" >共${num_p }页</a></li>
                            <li> <a  href="###" >共${num_b }条</a></li>
                            <li> <a  href="###"  type="text/html">&raquo;</a></li>
                        </ul>-->
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