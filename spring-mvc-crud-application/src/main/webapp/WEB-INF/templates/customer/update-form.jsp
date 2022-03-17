<%--
  User: mikholskiyivan
  Date: 3/17/22 7:53 PM
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer form</title>
    <style>
        <%@include file="../../../WEB-INF/static/css/style.css" %>
    </style>
</head>
<body>
<h1>Enter information about new customer</h1>
<%--@elvariable id="customer" type="me.mikholskiy.domains.Customer"--%>
<form:form method="post" modelAttribute="customer" action="/customer/update">
    Id: ${customer.id}
    <br><br>
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

