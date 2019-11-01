<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <jsp:include page="index.jsp"/>
        <form action="${pageContext.request.contextPath}/registration/add" method="post">
        <div class="container">
            <h1>Registration</h1>
            <p>Please fill in the form:</p>
            <label><b>Username</b></label>
            <input type="text" placeholder="" name="Username" required>
            <label><b>First name</b></label>
            <input type="text" placeholder="" name="First name" required>
            <label><b>Last name</b></label>
            <input type="text" placeholder="" name="Last name" required>
            <label><b>Email</b></label>
            <input type="text" placeholder="" name="Email" required>
            <label><b>Password</b></label>
            <input type="password" placeholder="" name="Password" required>
            <label><b>Repeat password</b></label>
            <input type="password" placeholder="" name="Repeat password" required>
            <button type="submit">Register</button>
        </div>
        </form>
    </body>
</html>
