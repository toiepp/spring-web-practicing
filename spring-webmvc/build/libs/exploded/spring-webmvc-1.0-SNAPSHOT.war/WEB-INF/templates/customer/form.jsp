<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer form</title>
    <style><%@include file="../../static/css/style.css"%></style>
</head>
<body>

<%--@elvariable id="customer" type="me.mikholskiy.domains.Customer"--%>
<form:form method="get" action="/customer/confirmation" modelAttribute="customer">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name (*): <form:input path="lastName"/> <form:errors path="lastName" cssClass="field-error"/>
    <br><br>
    Free passes: <form:input path="freePasses"/> <form:errors path="freePasses" cssClass="field-error"/>
    <br><br>
    Postal code: <form:input path="postalCode"/> <form:errors path="postalCode" cssClass="field-error"/>
    <br><br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
