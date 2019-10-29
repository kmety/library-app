<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Index page</title>
  </head>
  <body>
      <a href="${pageContext.request.contextPath}/book/all">All books</a>
      <br>
      <a href="${pageContext.request.contextPath}/user/login">Login</a>
      <br>
      <a href="${pageContext.request.contextPath}/user/register">Registration</a>
  </body>
</html>
