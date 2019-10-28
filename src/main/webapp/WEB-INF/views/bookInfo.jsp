<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Book</title>
    </head>
    <body>
        <form>
            <div align="center"></div>
            <h1>Book info:</h1>
            <table border="2">
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Year</th>
                    <th>Price</th>
                </tr>
                    <tr>
                        <td><c:out value="${book.id}"/></td>
                        <td><c:out value="${book.title}"/></td>
                        <td><c:out value="${book.year}"/></td>
                        <td><c:out value="${book.price}"/></td>
                    </tr>
            </table>
        </form>
    </body>
</html>
