<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>Add book form</title>
    </head>
    <body>
        <form:form method="post" modelAttribute="bookForm" action="${pageContext.request.contextPath}/book/add">
            <table>
                <tr>
                    <td><form:label path="title">Book title:</form:label></td>
                    <td><form:input path="title"/></td>
                </tr>
                <tr>
                    <td><form:label path="year">Year:</form:label></td>
                    <td><form:input path="year"/></td>
                </tr>
                <tr>
                    <td><form:label path="price">Price:</form:label></td>
                    <td><form:input path="price" type="number" step="0.01" min="0"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Confirm"/></td>
                </tr>
            </table>
        </form:form>
        <a href="${pageContext.request.contextPath}/book/all">All books page</a>
    </body>
</html>
