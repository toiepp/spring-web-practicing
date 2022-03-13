<%--
  User: mikholskiyivan
  Date: 3/12/22 2:46 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer form</title>
    <style><%@include file="../../static/css/style.css"%></style>
</head>
<body>

<form:form method="get" action="/customer/confirmation" modelAttribute="customer">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name (*): <form:input path="lastName"/> <form:errors path="lastName" cssClass="field-error"/>
    <br><br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
