<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
<h2> Spring Security Home Page</h2>
<hr>
    <p>
    Welcome the the Security demo page - silly
    </p>

    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout"
           method="POST">
        <input type="submit" value="Logout">

    </form:form>
</body>
</html>
