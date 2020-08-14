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
    <script src="../js/base1.js"></script>
    <link rel="stylesheet"  href="//at.alicdn.com/t/font_361592_j2u0npmvvt3dte29.css?ver=5.0.4" type="text/css" media="all">
    <link rel="stylesheet" href="../css1/base.css">

</head>
<body class="uk-height-1-1" style="background: #e9e9e9;" >




                            <article class="uk-comment">
                                <c:forEach items="${text.comment}" var="comment">
                                    <h6 class="uk-comment-title uk-clearfix"><cite>${comment.name}</cite>&nbsp;&nbsp;&nbsp;<time>${comment.date}</time><span class="uk-comment-meta uk-float-right qzhai_bgc"></span></h6>
                                    <p>${comment.details}</p>
                                </c:forEach>
                            </article>



</body>
</html>