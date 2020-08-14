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
    <link rel="stylesheet" href="../css1/base.css">

</head>
<body class="uk-height-1-1" style="background: #e9e9e9;" >
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
                            <li style="float: none;text-align: center;width: 100%; border-top:1px solid #ccc;"  id="menu-item-112" class=""><a class="hov" href="#" onclick="flush()">首页</a></li>
                            <li style="float: none;text-align: center;width: 100%; border-top:1px solid #ccc;"   class="uk-parent" data-uk-dropdown="{pos:'right-top'}"><a   class="hov" href="#" onclick="showAtRight('../q_action/guest_classify?username=${blog.username}')" >分类</a></li>
                            <li style="float: none;text-align: center;width: 100%; border-top:1px solid #ccc;"   class="uk-parent" data-uk-dropdown="{pos:'right-top'}"><a   class="hov" href="#" onclick="showAtRight('../q_action/guest_label?username=${blog.username}')" >标签</a></li>
                            <li style="float: none;text-align: center;width: 100%; border-top:1px solid #ccc;"  id="menu-item-54" class="uk-parent" data-uk-dropdown="{pos:'right-top'}"><a   class="hov" href="#" onclick="showAtRight('../q_action/guest_message?username=${blog.username}') " >留言板</a></li>
                            <li style="float: none;text-align: center;width: 100%; border-top:1px solid #ccc;"  id="menu-item-49" class="uk-parent" data-uk-dropdown="{pos:'right-top'}"><a   class="hov" onclick="showAtRight('../q_action/guest_texts?username=${blog.username}')">全部博文</a></li>

                        </ul>

                        <a href="javascript:;" id="op_m" lock="open" class="uk-icon-music"></a>
                    </div>
                </div>
                <div class="op" style="width:80%">
                    <iframe src="http://music.163.com/outchain/player?type=1&amp;id=3154175&amp;auto=0&amp;height=430" width="280" height="360" frameborder="no" marginwidth="0" marginheight="0"></iframe>
                </div>
            </div>
            <div class="ft uk-hidden-small">
                <p><a href="#my-link" data-uk-modal="">友情链接</a> - <a href="#" target="_black" title="大眼睛博客1.0" data-uk-tooltip="{pos:'bottom'}"> Big eye blog</a></p>
            </div>
        </div>

    </div>
</body>
</html>