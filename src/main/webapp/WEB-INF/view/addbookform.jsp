<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    <%@include file="bootstrap.css" %>
</style>
<input type="button" value="Admin Panel" onclick="window.location.href='${pageContext.request.contextPath}/books/manage';return false;" />
<html>
<head>
    <title>books</title>
</head>
<body>
ADD BOOK
<form:form action="saveBook" modelAttribute="book" method="POST">
<table>
    <tbody>
    <tr>
        <td><label>nazwa:</label></td>
        <td><form:input path="nazwa" /></td>
    </tr>
    <tr>
        <td><label>wydawnictwo:</label></td>
        <td><form:input path="wydawnictwo" /></td>
    </tr>

    <tr>
        <td><label>cena:</label></td>
        <td><form:input path="cena" /></td>
    </tr>

    <tr>
        <td><label></label></td>
        <td><input type="submit" value="Save" class="save" /></td>
    </tr>
    </tbody>
</table>
</form:form>

<p>
 <a href="${pageContext.request.contextPath}/books/list "> return </a>
</p>
</body>
</html>