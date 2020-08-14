<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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
    <link rel="stylesheet"  href="//at.alicdn.com/t/font_361592_j2u0npmvvt3dte29.css?ver=5.0.4" type="text/css" media="all">

    <link rel="stylesheet" href="../css/style.css">

</head>
<body style="background-color: ghostwhite;">

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
            <div class="row">

                <div class="col-sm-5 col-sm-offset-1">
                    <div class="panel panel-primary">
                        <div class=" panel-heading">
                            <span class="panel-title">数据统计</span>

                        </div>

                        <div class=" panel-body" >
                            <div class="col-sm-10 col-sm-offset-1" style="border-bottom: 1px solid #ccc;">
                                <br>欢迎您的登录</br> 快来写一篇文章记录下当下吧！</p>
                            </div>
                            <div class="col-sm-10 col-sm-offset-1" style="padding: 10px 0;">
                                <span  style=" width: 25%; color: #4b5cc4; vertical-align: middle !important;text-align: center;padding:15px 0;float: left; font-size:large;border-right: 1px solid #ccc;">文章<br><i>${fn:length(blog.text)}</i></span>
                                <span  style=" width: 25%; color: #4b5cc4; vertical-align: middle !important;text-align: center;padding:15px 0;float: left; font-size:large;border-right: 1px solid #ccc;">留言<br><i>${fn:length(blog.message)}</i></span>
                                <span  style=" width: 25%; color: #4b5cc4; vertical-align: middle !important;text-align: center;padding:15px 0;float: left; font-size:large;border-right: 1px solid #ccc;">分类<br><i>${fn:length(blog.classify)}</i></span>
                                <span  style=" width: 25%; color: #4b5cc4; vertical-align: middle !important;text-align: center;padding:15px 0;float: left; font-size:large; "                            >标签<br><i>${fn:length(blog.label)}</i></span>
                            </div>


                        </div>

                    </div>
                </div>
                <div class="col-sm-5  ">
                    <div class="panel panel-info">
                        <div class=" panel-heading">
                            <span class="panel-title">系统信息</span>

                        </div>
                        <ul class=" panel-body list-group">
                           <li class="list-group-item">去前端首页<a href="http://blog.bigeye.vip/q_action/index?id=${blog.username}">☛ 点我</a></li>
                           <li class="list-group-item">版本1.0</li>
                           <li class="list-group-item">修复前端页面布局bug</li>
                           <li class="list-group-item">修改后端页面配色</li>
                           <li class="list-group-item">增加后端文章点击查看</li>
                        </ul>

                    </div>
                </div>
            </div>
            <br>
            <br>
            <div class="row ">
                <div class=" col-sm-10 col-sm-offset-1  ">
                    <div class="panel panel-success ">
                        <div class=" panel-heading">
                            <span class="panel-title">消息盒子</span>
                            <span class="badge ">${fn:length(blog_news)}</span>
                            <span class="pull-right "><a href="../delete/newsAll" class="btn-xs btn-danger">全部已读</a></span>

                        </div>
                        <div class=" panel-body">
                           <div>
                               <ul class="list-unstyled" style="width:100%;">
                                   <c:forEach items="${blog_news}" var="n">
                                   <li style="width:100%;border-bottom: 1px solid #ccc;display:inline-block;">
                                       <div class="pull-left" style="width: 100%;" > <span class="text-info">${n.value}</span><span style="padding-right: 5px;float: right" ><a style="margin-left: 5px;" class="btn btn-xs btn-success " href="../action/news?id=${n.id}">详情</a></span></div>
                                       <br>
                                       <div class="pull-right" style="width: 100%;margin-top: 20px;margin-bottom: 10px;"> <span class="pull-right"><span>来自&nbsp;${n.name}</span>&nbsp;&nbsp;<span><time><i class="iconfont icon-rili"></i>&nbsp;${n.date}</time></span></span></div>
                                   </li>
                                   </c:forEach>
                               </ul>
                           </div>


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