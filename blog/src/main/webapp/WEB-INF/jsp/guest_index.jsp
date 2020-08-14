<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html  style="background: #e9e9e9;" >
<head>
    <meta charset="utf-8" />
    <title>大眼睛博客1.0</title>
    <meta name="keywords" content="Wolf blog" />
    <meta name="description" content="Wolf blog" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <meta name="robots" content="noindex,follow" />
    <link rel="stylesheet" id="wp-block-library-css" href="../css1/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../css1/style.min.css" type="text/css" media="all" />
    <link rel="stylesheet" id="qzhai-css" href="../css1/style_o.css" type="text/css" media="all" />
    <link rel="stylesheet" id="highlight-css" href="../css1/code/sunburst.css" type="text/css" media="all" />
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script src="../js/app.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../js/base.js"></script>
    <link rel="stylesheet"  href="//at.alicdn.com/t/font_361592_j2u0npmvvt3dte29.css?ver=5.0.4" type="text/css" media="all">

    <link rel="stylesheet" href="../css1/base.css">

</head>
<body class="uk-height-1-1" style="background: #e9e9e9;" >
<div id="main" class="wp uk-grid uk-grid-collapse" style="max-width:1120px">
    <div class="uk-width-small-1-1 uk-width-medium-1-4 uk-width-large-1-6 posr " id="bg">
        <div id="head" data-uk-sticky="{boundary: true,top:80}">
            <div id="op_head" class="navbar navbar-fixed-top navbar-inverse" style="background-color: white;">
                <div class="uk-panel bs" id="op_hed">
                    <div class="tx">
                        <div class="avatar_">
                            <img src="${blog.logo}" />
                        </div>
                    </div>
                    <h1 class="uk-panel-title"><a href="#">${blog.name}</a></h1>
                    <span>${blog.sign}</span>
                    <div class="my uk-grid-collapse uk-grid uk-grid-width-1-3">
                        <div>
                            <span>${fn:length(blog.text)}</span>
                            <span><i class="uk-icon-file-text"></i></span>
                            <a href="#" title="文章" data-uk-tooltip="{pos:'bottom'}"></a>
                        </div>
                        <div>
                            <span>${fn:length(blog.classify)}</span>
                            <span><i class="uk-icon-folder"></i></span>
                            <a href="#" title="分类" data-uk-tooltip="{pos:'bottom'}"></a>
                        </div>
                        <div>
                            <span>${fn:length(blog.label)}</span>
                            <span><i class="uk-icon-tags"></i></span>
                            <a href="#" title="标签" data-uk-tooltip="{pos:'bottom'}"></a>
                        </div>
                    </div>
                    <div class="navbar-header" style="text-align: center;">
                        <button type="button" style="float:none;background-color: white;border: none;" class="navbar-toggle" data-toggle="collapse" data-target="#navBar">
                            <span  style="border: 1px solid #333333;" class="icon-bar"></span>
                            <span  style="border: 1px solid #333333;" class="icon-bar"></span>
                            <span  style="border: 1px solid #333333;" class="icon-bar"></span>
                        </button>
                    </div>

                    <div  class="collapse navbar-collapse " id="navBar" style="background-color: white; border: none;border-radius: 15px;">
                        <ul id="nav-top" class="nav uk-nav  nav navbar-nav " style="width: 100%;" >
                            <li style="float: none;text-align: center;width: 100%; border-top:1px solid #ccc;"  id="menu-item-112" class=""><a class="hov"  href="../q_action/index?id=${blog.username}">首页</a></li>
                            <li style="float: none;text-align: center;width: 100%; border-top:1px solid #ccc;"   class="uk-parent" data-uk-dropdown="{pos:'right-top'}"><a   class="hov" href="../q_action/guest_classify?username=${blog.username}" >分类</a></li>
                            <li style="float: none;text-align: center;width: 100%; border-top:1px solid #ccc;"   class="uk-parent" data-uk-dropdown="{pos:'right-top'}"><a   class="hov" href="../q_action/guest_label?username=${blog.username}" >标签</a></li>
                            <li style="float: none;text-align: center;width: 100%; border-top:1px solid #ccc;"  id="menu-item-54" class="uk-parent" data-uk-dropdown="{pos:'right-top'}"><a   class="hov" href="../q_action/guest_message?username=${blog.username} " >留言板</a></li>
                            <li style="float: none;text-align: center;width: 100%; border-top:1px solid #ccc;"  id="menu-item-49" class="uk-parent" data-uk-dropdown="{pos:'right-top'}"><a   class="hov" href="../q_action/guest_texts?username=${blog.username}">全部博文</a></li>

                        </ul>

                        <a href="javascript:;" id="op_m" lock="open" class="uk-icon-music"></a>
                    </div>
                </div>
                <div class="op" style="width:80%">
                    <iframe src="http://music.163.com/outchain/player?type=1&amp;id=3154175&amp;auto=0&amp;height=430" width="280" height="360" frameborder="no" marginwidth="0" marginheight="0"></iframe>
                </div>
            </div>
            <div class="ft uk-hidden-small">
                <p><a  rel="nofollow" href="http://www.beian.miit.gov.cn" target="_blank" data-uk-tooltip="{pos:'bottom'}">陇ICP备19003156号</a></p>
</div>
        </div>

    </div>
    <div id="content" class="uk-width-small-1-1 uk-width-medium-3-4 uk-width-large-5-6 uk-grid uk-grid-collapse">
        <div class="uk-width-small-1-1 uk-width-medium-3-4 uk-width-large-7-10">
            <div id="index" class="bs uk-text-break">
                <h4>最新文章</h4>
                <div id="list">
                    <c:forEach items="${new_text}" var="text">
                    <article class="article class_3">
                        <h1><a href="../q_action/guest_text?id=${text.id}&username=${blog.username }">${text.title}</a></h1>

                            ${text.details.value}


                       <time style="float: right;"><i class="iconfont icon-rili"></i>&nbsp;${text.date}</time>
                    </article>
                    </c:forEach>
                </div>
            </div>

            <ul class="uk-pagination">
            </ul>
        </div>
        <div id="sidebar" class="uk-width-small-1-1 uk-width-medium-1-4 uk-width-large-3-10">
            <ul class="ul" >
                <li><h4>温馨提示</h4>
                    <div class="textwidget">
                        <p>觉得博客还不错，去注册吧&nbsp;&nbsp;&nbsp;&nbsp;<a href="../action/register" target="_blank" rel="noopener">注册</a></p>
                        <p>已有账号？登录后台&nbsp;&nbsp;&nbsp;&nbsp;<a href="../action/login" target="_blank" rel="noopener">登录</a></p>
                        <p>有建议或者问题均可留言&nbsp;&nbsp;&nbsp;&nbsp;<a href="../q_action/guest_message?username=${blog.username}" target="_blank" rel="noopener">留言</a></p>
                        <p>博客个人首页地址命名规则：blog.bigeye.vip/index?id=username username为您的用户名</p>
                    </div> </li>
            </ul>
            <ul id="ulsid" class="ul">
                <li >

                    <h4>最新发表</h4>
                    <ul >
                        <c:forEach items="${new_text}" var="text">
                            <li> <a  class="hov" href="../q_action/guest_text?id=${text.id}&username=${blog.username}">${text.title}</a> </li>
                        </c:forEach>


                    </ul>
                </li>


                <li>
                    <h4>还想逛</h4>
                    <ul>

                        <li><a href="#">看看其他热门博主</a></li>

                    </ul>
                </li>
                <li>
                    <h4>标签</h4>
                   <div class="post-tags">


                            <c:forEach items="${blog.label}" var="label">
                            <a   id="lc" href="../q_action/select_label?username=${blog.username}&id=${label.id}" >${label.name}</a>
                            </c:forEach>
                   </div>
                </li>
                <li >
                    <img src="../img/background01.jpg">
                </li>
            </ul>


        </div>
        <div class="ft uk-visible-small">
            <p><a href="#my-link" data-uk-modal="">友情链接</a> - <a href="http://blog.bigeye.vip" target="_black" title="大眼睛博客1.0" data-uk-tooltip="{pos:'bottom'}"> Big eye blog</a></p>
        </div>
    </div>

    <a href="#" class="top" data-uk-smooth-scroll="" style="display:none"><i class="uk-icon-angle-up"></i></a>
    <div id="my-link" class="uk-modal">
        <div class="uk-modal-dialog">
            <a class="uk-modal-close uk-close"></a>
            <h2>友情链接</h2>
            <ul id="link_qzhai" class=" uk-subnav uk-subnav-line">
                <li id="menu-item-40" class=""><a href="http://blog.bigeye.vip" class="qzhai_bgc_hover">大眼睛</a></li>

            </ul>
        </div>
    </div>
</div>

</body>
</html>