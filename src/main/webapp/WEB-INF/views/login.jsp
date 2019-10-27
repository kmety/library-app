<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h1>Custom login page</h1>
        <c:url value="/user/login" var="loginUrl"/>
        <form action="${loginUrl}" method="post">
            <c:if test="${param.error != null}">
                <p>
                    Invalid username or password.
                </p>
            </c:if>
            <c:if test="${param.logout != null}">
                <p>
                    You have been logged out.
                </p>
            </c:if>
            <p>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
            </p>
            <button type="submit" class="btn">Log in</button>
        </form>
        <a href="${pageContext.request.contextPath}/user/register">Register new user</a>
    </body>
</html>
