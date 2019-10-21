<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>All books</title>
    </head>
    <body>
        <table border="2">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Info</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.price}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/info?book_id=${book.id}">Info</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/delete?book_id=${book.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
    </body>
</html>
