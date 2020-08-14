<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>大眼睛博客1.0</title>
    <meta name="keywords" content="Wolf blog" />
    <meta name="description" content="Wolf blog" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <meta name="robots" content="noindex,follow" />
    <link rel="stylesheet" id="qzhai-css" href="../css1/style_o.css" type="text/css" media="all" />
    <link rel="stylesheet" id="highlight-css" href="../css1/code/sunburst.css" type="text/css" media="all" />
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        #list img,#list .bg{
            opacity: .7 !important;
            -moz-transition: all 0.2s ease-in;
            -webkit-transition: all 0.2s ease-in;
            -o-transition: all 0.2s ease-in;
            -ms-transition: all 0.2s ease-in;
            transition: all 0.2s ease-in;
        }
        #list img:hover,#list .bg:hover{
            opacity: 1 !important;
        }</style>
</head>
<body class="uk-height-1-1">
<div id="main" class="wp uk-grid uk-grid-collapse" style="max-width:1120px">
    <div class="uk-width-small-1-1 uk-width-medium-1-4 uk-width-large-1-6 posr">
        <div id="head" data-uk-sticky="{boundary: true,top:80}">
            <div id="op_head">
                <div class="uk-panel bs" id="op_hed">
                    <div class="tx">
                        <div class="avatar_">
                            <img src="#" />
                        </div>
                    </div>
                    <h1 class="uk-panel-title"><a href="#">博主</a></h1>
                    <span>这是一个演示站点</span>
                    <div class="my uk-grid-collapse uk-grid uk-grid-width-1-3">
                        <div>
                            <span>15</span>
                            <span><i class="uk-icon-file-text"></i></span>
                            <a href="#" title="文章" data-uk-tooltip="{pos:'bottom'}"></a>
                        </div>
                        <div>
                            <span>3</span>
                            <span><i class="uk-icon-folder"></i></span>
                            <a href="#" title="分类" data-uk-tooltip="{pos:'bottom'}"></a>
                        </div>
                        <div>
                            <span>©</span>
                            <span><i class="uk-icon-tags"></i></span>
                            <a href="#" title="作者" data-uk-tooltip="{pos:'bottom'}"></a>
                        </div>
                    </div>
                    <a href="javascript:void(0)"
                       class="s_s uk-navbar-toggle uk-hidden-large" data-uk-offcanvas="">
                        <button type="button" class="hamburger is-open animated fadeInLeft" data-toggle="offcanvas">
                            <span class="hamb-top"></span>
                            <span class="hamb-middle"></span>
                            <span class="hamb-bottom"></span>
                        </button>
                    </a>
                    <ul id="sidebar-wrapper" role="navigation" class="nav navbar-inverse navbar-fixed-top uk-nav ">
                        <li id="menu-item-112" class=""><a href="#" class="qzhai_bgc_hover">全部博文</a></li>
                        <li id="menu-item-54" class="uk-parent" data-uk-dropdown="{pos:'right-top'}"><a href="#" class="qzhai_bgc_hover">留言板</a>
                        </li>

                        <li id="menu-item-49" class="uk-parent" data-uk-dropdown="{pos:'right-top'}"><a href="#" class="qzhai_bgc_hover">关于作者</a>
                        </li>
                    </ul>
                    <form role="search" class="s uk-form uk-hidden-small" id="searchform" method="get" action="#">
                        <input class="uk-width-1-1 qzhai_bgc_hover " type="text" value="" name="s" id="s" placeholder="搜索" />
                    </form>
                    <a href="javascript:;" id="op_m" lock="open" class="uk-icon-music"></a>
                </div>
                <div class="op" style="width:80%">
                    <iframe src="http://music.163.com/outchain/player?type=1&amp;id=3154175&amp;auto=0&amp;height=430" width="280" height="380" frameborder="no" marginwidth="0" marginheight="0"></iframe>
                </div>
            </div>
            <div class="ft uk-hidden-small">
                <p><a href="#my-link" data-uk-modal="">友情链接</a> - <a href="#" target="_black" title="大眼睛博客1.0" data-uk-tooltip="{pos:'bottom'}"> Big eye blog</a></p>
            </div>
        </div>
    </div>
    <div id="content" class="uk-width-small-1-1 uk-width-medium-3-4 uk-width-large-5-6 uk-grid uk-grid-collapse">
        <div class="uk-width-small-1-1 uk-width-medium-3-4 uk-width-large-7-10">
            <div id="index" class="bs uk-text-break">
                <h1 class="h4">分类</h1>
                <div id="list" class="category">
                    <p class="date"><strong>衫小小寨</strong>目前共有分类：3   </p>

                    <a href="http://qzhai.net/000/archives/category/my_______" title=""  data-uk-tooltip>我的书柜 (10)</a>

                </div>
            </div>
        </div>
        <div id="sidebar" class="uk-width-small-1-1 uk-width-medium-1-4 uk-width-large-3-10">
            <ul class="ul">
                <li><h4>提示</h4>
                    <div class="textwidget">
                        <p>觉得博客还不错，去注册吧<a href="#" target="_blank" rel="noopener">注册</a></p>
                    </div> </li>
                <li> <h4>最新发表</h4>
                    <ul>

                        <li> <a href="http://qzhai.net/000/archives/1">世界，您好！</a> </li>

                    </ul>
                </li>
            </ul>
            <ul id="ulsid" class="ul">
                <li><h4>文章归档</h4>
                    <ul>

                        <li><a href="http://qzhai.net/000/archives/date/2015/12">2015年十二月</a></li>

                    </ul> </li>


            </ul>
        </div>
        <div class="ft uk-visible-small">
            <p><a href="#my-link" data-uk-modal="">友情链接</a> - <a href="http://qzhai.net" target="_black" title="大眼睛博客1.0" data-uk-tooltip="{pos:'bottom'}"> Big eye blog</a></p>
        </div>
    </div>

    <a href="#" class="top" data-uk-smooth-scroll="" style="display:none"><i class="uk-icon-angle-up"></i></a>
    <div id="my-link" class="uk-modal">
        <div class="uk-modal-dialog">
            <a class="uk-modal-close uk-close"></a>
            <h2>友情链接</h2>
            <ul id="link_qzhai" class=" uk-subnav uk-subnav-line">
                <li id="menu-item-40" class=""><a href="blog.bigeye.vip.blog" class="qzhai_bgc_hover">大眼睛</a></li>

            </ul>
        </div>
    </div>
</div>
</body>
</html>