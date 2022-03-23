<%--
  User: mikholskiyivan
  Date: 3/23/22 9:50 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="section" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<h1>Hello!</h1>
<hr>
<%-- User ID  --%>
User: <security:authentication property="principal.username"/>
<br>
<%-- User Role --%>
Role(s): <section:authentication property="principal.authorities"/>
<hr>
<security:authorize access="hasRole('EMPLOYEE')">
    <p>Beep bop, You are trash!</p>
</security:authorize>
<security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leader">Leadership Meeting</a>
    </p>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/system">IT System Meeting</a>
    </p>
</security:authorize>
<hr>
<form:form action="${pageContext.request.contextPath}/logout"
           method="post">
    <input type="submit" value="Logout">
</form:form>
</body>
</html>
