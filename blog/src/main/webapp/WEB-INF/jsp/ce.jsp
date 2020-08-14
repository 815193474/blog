<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>

</head>
<body>
<c:forEach items="${blogs}" var="b" varStatus="varStatus">
    <p>${b.username}</p>
    <p>${b.passwd}</p>
    <p>${varStatus.index+1}</p>

</c:forEach>

</body>
</html>