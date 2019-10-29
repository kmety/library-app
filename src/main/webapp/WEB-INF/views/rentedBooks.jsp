<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Info</th>
        <th>Return</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.price}</td>
            <td>
                <a href="${pageContext.request.contextPath}/book/${book.id}">Info</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/rent/returnBook?book_id=${book.id}">Return</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="${pageContext.request.contextPath}/book/all">All books</a>
</body>
</html>
