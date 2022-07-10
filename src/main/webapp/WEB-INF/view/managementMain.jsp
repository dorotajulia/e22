<%--
  Created by IntelliJ IDEA.
  User: dorot
  Date: 08.07.2022
  Time: 02:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    <%@include file="bootstrap.css" %>
</style>
<html>
<head>
    <title>Manage Inventory</title>
</head>
<body>
<h1>Bookstore Manager</h1>
<div><h3>Books</h3></div>
<div>
    <input type="button" value="Add Book"
           onclick="window.location.href='formadd';return false;" />
</div>
<div>
    <input type="button" value="Remove Book"
           onclick="window.location.href='deleteForm';return false;" />
</div>
<div>
    <input type="button" value="Update Book"
           onclick="window.location.href='chooseBookToUpdate';return false;" />
</div>
<div>
    <input type="button" value="See all books"
           onclick="window.location.href='list';return false;" />
</div>
<div><h3>Orders</h3></div>
<div>
    <input type="button" value="See all orders"
           onclick="window.location.href='${pageContext.request.contextPath}/orders/adminOrderList';return false;" />
</div>
</body>
</html>


