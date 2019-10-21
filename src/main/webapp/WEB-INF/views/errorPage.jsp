<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Something went wrong</title>
</head>
<body>
    <h1>${message}</h1>
    <a href="${pageContext.request.contextPath}/book/all">Return to the books page</a>
</body>
</html>
