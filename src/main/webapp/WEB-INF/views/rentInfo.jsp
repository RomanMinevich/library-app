<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Rent</title>
    </head>
    <body>
        <h2>Rent info:</h2>
            <table border="2">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Year</th>
                <th>Price</th>
                <th>Info</th>
                <th>Authors</th>
                <th>Rent</th>
            </tr>
            <c:forEach var="book" items="${rentByUser}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.year}</td>
                    <td>${book.price}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/${book.id}">Info</a>
                    </td>
                    <td>${book.authors}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/rent/return?bookId=${book.id}">Return</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
