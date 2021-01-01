<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


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

    <hr>
    <!-- display user name and role   -->
    <p>
        User: <security:authentication property="principal.username"/>
        <br><br>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>
    <security:authorize access="hasRole('MANAGER')">

    <%-- Add a link to point to /leadrs ... this ifor the managers --%>

    <p>
        <a href="${pageContext.request.contextPath}/usersettings">User Settings</a>
        (Only for Upper Manager)
    </p>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/systemsettings">System Settings</a>
        (Only for Admin)
    </p>
    </security:authorize>



    <hr>

    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout"
           method="POST">
        <input type="submit" value="Logout">

    </form:form>

</body>
</html>
