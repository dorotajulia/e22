<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style type="text/css">
    <%@include file="bootstrap.css" %>
</style>
<input type="button" value="Admin Panel" onclick="window.location.href='${pageContext.request.contextPath}/books/manage';return false;" />
<html>
<head>
    <title>Update Book</title>
</head>
<body>
<h3>Choose a book to update</h3>
<form:form action="updateForm" modelAttribute="bookToUpDateID" method="POST">

    Select a Book:&nbsp;
    <select name="bookToUpDateID">
        <c:forEach items="${books}" var="books">
            <option value="${books.getId()}">
                    ${books.getId()} : ${books.nazwa}
            </option>
        </c:forEach>
    </select>


    <br/><br/>
    <input type="submit" name="submit" value="Update"  />
</form:form>
<a href="${pageContext.request.contextPath}/books/manage "> return </a>
</body>
</html>
