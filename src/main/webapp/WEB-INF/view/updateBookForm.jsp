<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style type="text/css">
    <%@include file="bootstrap.css" %>
</style>
<input type="button" value="Admin Panel" onclick="window.location.href='${pageContext.request.contextPath}/books/manage';return false;" />
<html>
<head>
    <title>books</title>
</head>
<body>
UPDATE BOOK
<form:form action="updateBook/${book.getId()}" modelAttribute="bookToUpDate" method="POST">
    <table>
        <tbody>
        <tr>
            <td><label>nazwa:</label></td>
            <td><form:input path="nazwa" value="${book.nazwa}"/></td>
        </tr>
        <tr>
            <td><label>wydawnictwo:</label></td>
            <td><form:input path="wydawnictwo" value="${book.wydawnictwo}"/></td>
        </tr>
        <tr>
            <td><label>cena:</label></td>
            <td><form:input path="cena" value="${book.cena}"/></td>
        </tr>
        <tr>
            <!-- <td><label>kategoria:</label></td>-->
            <!-- <td><form:input path="kategoria" /></td> -->
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Update"  /></td>
        </tr>
        </tbody>
    </table>
</form:form>

<p>
    <a href="${pageContext.request.contextPath}/books/manage "> return </a>
</p>
</body>
</html>