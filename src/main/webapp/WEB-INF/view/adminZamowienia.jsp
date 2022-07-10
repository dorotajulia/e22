<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/tags/form" %>
<style type="text/css">
    <%@include file="bootstrap.css" %>
</style>
<input type="button" value="Admin Panel" onclick="window.location.href='${pageContext.request.contextPath}/books/manage';return false;" />
<c:url var="logoutUrl" value="/j_spring_security_logout" />
<form action="${logoutUrl}" id="logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>
<html>
<head>
    <title>List books</title>
</head>
<body>
<h2>Books:</h2>
<div>
    <table>
        <tr>
            <th>Data</th>
            <th>Ksiazki</th>
            <th>Cena</th>
            <th>Status</th>
            <th>Uzytkownik</th>
            <th>Zmien status</th>

            <th></th>

        </tr>
        <c:forEach var="orders" items="${orders}" >
            <tr>
                <td>${orders.date_time}</td>
                <td>${orders.ksiazkiString}</td>
                <td>${orders.price}</td>
                <td>${orders.status}</td>
                <td>${orders.username}</td>
                <td>
                    <form:form action="${pageContext.request.contextPath}/orders/complete">
                        <input type="hidden" id="orderId" name="orderId" value="${orders.getId()}"/>
                        <button type="submit" >Zrealizowane</button>
                    </form:form>
                </td>


                    <%--                <td>${books.getAutorzyString()} </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
<%--<div>--%>
<%--    <input type="button" value="Add Book"--%>
<%--           onclick="window.location.href='formadd';return false;" />--%>
<%--</div>--%>
</body>
</html>