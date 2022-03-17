<%--
  User: mikholskiyivan
  Date: 3/17/22 11:51 AM
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer form</title>
    <style><%@include file="../../../WEB-INF/static/css/style.css"%></style>
</head>
<body>
<h1>Enter information about nwe customer</h1>
<%--@elvariable id="customer" type="me.mikholskiy.domains.Customer"--%>
<form:form method="post" modelAttribute="customer" action="/customer/new">
    First name: <form:input path="firstName"/> <form:errors path="firstName" cssClass="error"/>
    <br><br>
    Last name: <form:input path="lastName"/> <form:errors path="lastName" cssClass="error"/>
    <br><br>
    Email: <form:input path="email"/> <form:errors path="email" cssClass="error"/>
    <br><br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
