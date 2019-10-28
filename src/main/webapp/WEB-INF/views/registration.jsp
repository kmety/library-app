<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form method="post" modelAttribute="userDto" action="${pageContext.request.contextPath}/user/register">
    <table>
        <tr>
            <td><form:label path="firstName">First name:</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last name:</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email:</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="userName">Login:</form:label></td>
            <td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password:</form:label></td>
            <td><form:input path="password" type="password"/></td>
        </tr>
        <tr>
            <td><form:label path="repeatPassword">Repeat password:</form:label></td>
            <td><form:input path="repeatPassword" type="password"/></td>
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
