<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>login</title>
    </head>
    <body>
        <jsp:include page="index.jsp"/>
        <c:url value="/login" var="loginUrl"/>
        <form action="${loginUrl}" method="post">
            <c:if test="${param.error != null}">
                <p>Invalid username or password</p>
            </c:if>
            <c:if test="${param.logout != null}">
                <p>You've been logged out</p>
            </c:if>
            <p><label><b>Username</b></label><input type="text" placeholder="" name="Username" required></p>
            <p><label><b>Password</b></label><input type="password" placeholder="" name="Password" required></p>
            <button type="submit">Log in</button>
        </form>
    </body>
</html>
