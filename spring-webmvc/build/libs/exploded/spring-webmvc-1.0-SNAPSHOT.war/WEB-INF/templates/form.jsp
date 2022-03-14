<%--
  User: mikholskiyivan
  Date: 3/12/22 10:02 AM
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello world</title>
</head>
<body>

<%--@elvariable id="student" type="me.mikholskiy.domains.Student"--%>
<form:form action="/process-form" modelAttribute="student" method="get">
    First name: <form:input path="firstName"/> <form:errors path="firstName" cssClass="field-error"/>
    <br><br>
    Last name: <form:input path="lastName"/> <form:errors path="lastName" cssClass="field-error"/>
    <br><br>
    Age: <form:input path="age"/>
    <br><br>
    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>
    <br><br>
    Java <form:radiobutton path="progLang" value="Java"/>
    C++ <form:radiobutton path="progLang" value="C++"/>
    <br><br>
    Unix-based <form:checkbox path="operatingSystems" value="Unix"/>
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
    Windows <form:checkbox path="operatingSystems" value="Windows"/>
    <br><br>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>
