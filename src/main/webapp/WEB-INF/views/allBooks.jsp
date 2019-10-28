<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Books</title>
    </head>
    <body>
        <form>
        <div align="center"></div>
        <h1>Books:</h1>
            <table border="2">
                <tr>
                    <th>Title</th>
                    <th>Info</th>
                </tr>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td><c:out value="${book.title}"/></td>
                        <td><a href="/book/${book.id}">bookInfo</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
