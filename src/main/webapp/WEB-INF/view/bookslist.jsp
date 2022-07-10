<%--
  Created by IntelliJ IDEA.
  User: dorot
  Date: 07.07.2022
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/tags/form" %>
<style type="text/css">
    <%@include file="bootstrap.css" %>
</style>
<input type="button" value="my profile" onclick="window.location.href='${pageContext.request.contextPath}/books/user';return false;" />

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
            <th>Nazwa</th>
            <th>Wydawnictwo</th>
            <th>Cena</th>
            <th>Kategoria</th>

                <th>Do koszyka</th>

        </tr>
        <c:forEach var="books" items="${books}" >
            <tr>
                <td>${books.nazwa}</td>
                <td>${books.wydawnictwo}</td>
                <td>${books.cena}</td>
                <td>${books.kategoria.nazwa}</td>

                <td>
                        <form:form action="${pageContext.request.contextPath}/cart/add">
                    <input type="hidden" id="bookId" name="bookId" value="${books.getId()}"/>
                    <button type="submit" >Do koszyka</button>
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
