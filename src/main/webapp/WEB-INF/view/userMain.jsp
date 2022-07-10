<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    <%@include file="bootstrap.css" %>
</style>
<html>
<div class="navbar navbar-inverse navbar-fixed-top" >
    <div>
        <c:url var="logoutUrl" value="/j_spring_security_logout" />
        <form action="${logoutUrl}" id="logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>
        <a href="#" onclick="document.getElementById('logout').submit();">Logout</a>
    </div>
</div>
<div class="navbar">

</div>
<head>
    <title>User</title>
</head>
<body align="centre">
<h2 style="text-align:center">Hi, ${username}!</h2>
<h4 style="text-align:center">Menu</h4>


<div style="text-align:center;margin: 10px">
    <input type="button" value="Shop" onclick="window.location.href='${pageContext.request.contextPath}/books/list';return false;" />
</div>
<div style="text-align:center;margin: 10px">
    <input type="button" value="Cart"
           onclick="window.location.href='${pageContext.request.contextPath}/cart';return false;" />
</div>
<div style="text-align:center;margin: 10px">
    <input type="button" value="Orders"
           onclick="window.location.href='${pageContext.request.contextPath}/orders/userOrderList';return false;" />
</div>
</body>
</html>
