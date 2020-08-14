<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17 0017
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"> </script>
  <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
  <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
  <script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>
  <script type="text/javascript">
    var ue = UE.getEditor('editor');

  </script>
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
              <span class="panel-title">写博客</span>

            </div>
            <div class=" panel-body">
              <br>
              <form role="role" action="../upload/text" method="post" name="upfile">
                <div class="input-group">
                  <span class="input-group-addon">标题</span>
                  <input type="text" class="form-control" name="title">
                </div><br>
                <div class="input-group">
                  <span class="input-group-addon">版权</span>
                  <select name="copyright" class="form-control">
                    <option value="原创">原创</option>
                    <option value="转载">转载</option>

                  </select>
                </div><br>
                <div class="input-group">
                  <span class="input-group-addon">分类</span>
                  <select name="classify" class="form-control">
                    <c:forEach items="${classify}" var="classify">

                    <option value="${classify.id}">${classify.name}</option>
                    </c:forEach>
                  </select>
                </div><br>
                <div class="input-group">
                  <span class="input-group-addon">标签</span>
                  <select name="label" class="form-control">
                    <c:forEach items="${label}" var="label">

                    <option value="${label.id}">${label.name}</option>
                    </c:forEach>
                  </select>
                </div><br>

                <div class="input-group" style="padding: 0;">

                    <textarea id="editor" name="upfile"  style="height: 200px;width:100%;   margin: 0;">

                    </textarea>

                </div><br>
                <input type="text" name="username" value="${blog.username}" style="display: none;">
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