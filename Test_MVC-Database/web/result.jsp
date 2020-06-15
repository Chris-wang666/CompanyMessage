<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/13
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<a href="view.html">返回主页</a><br>
<c:forEach items="${sessionScope.list}" var="company" varStatus="s">
    <h3>ID:${company.id}</h3>
    <h3>公司名称:${company.name}</h3>
    <h3>公司地址:${company.address}</h3>
    <h3>公司电话:${company.phone}</h3>
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
</c:forEach>
</body>
</html>
