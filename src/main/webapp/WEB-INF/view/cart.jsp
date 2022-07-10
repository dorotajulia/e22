<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
    <%@include file="bootstrap.css" %>
</style>
<input type="button" value="my profile" onclick="window.location.href='${pageContext.request.contextPath}/books/user';return false;" />

<a href="${pageContext.request.contextPath}/books/list " align="left"> return to booklist </a>
<c:url var="logoutUrl" value="/j_spring_security_logout" />
<form action="${logoutUrl}" id="logout" method="post" >
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<h2>CART:</h2>
<c:set var="total" value="${0.00}"/>
<c:choose>
<c:when test="${not empty books}">
<div>
<%--    <c:if test="not " ${books} != null >--%>

    <table>
        <tbody>
        <tr>
            <th>Nazwa</th>
            <th>Wydawnictwo</th>
            <th>Cena</th>
            <th>Kategoria</th>

            <th> </th>

        </tr>

        <c:forEach var="books" items="${books}">
            <tr>
                <td>${books.nazwa}</td>
                <td>${books.wydawnictwo}</td>
                <td>${books.cena}</td>
                <c:set var="total" value="${total + books.cena}" />
                <td>${books.kategoria.nazwa}</td>
<%--                <td><c:out value="${book.authorsToString()}"/></td>--%>
                <td>
                    <form:form action="${pageContext.request.contextPath}/cart/delete">
                        <input type="hidden" id="bookId" name="bookId" value="${books.getId()}"/>
                        <button type="submit">Usun</button>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<%--    </table>--%>
</div>
</c:when>
<c:otherwise>
<div>
    <h2>cart is empty</h2>
</div>
</c:otherwise>
</c:choose>
<div>
    <h3>Suma zamowienia:</h3>
    <h4><fmt:formatNumber value="${total}" minFractionDigits="2" maxFractionDigits="2"/> pln</h4>
    <form:form action="${pageContext.request.contextPath}/cart/createOrder">
        <input type="hidden" id="total" name="total" value="${total}"/>
        <button type="submit">Zloz zamowienie</button>
    </form:form>
</div>
</body>
</html>