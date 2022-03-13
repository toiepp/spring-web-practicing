<%--
  User: mikholskiyivan
  Date: 3/12/22 11:44 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student confirmation</title>
</head>
<body>
The student is confirmed: <strong>${student.firstName} ${student.lastName}</strong>, ${student.age} y.o.
<br><br>
So you've arrived from ${student.country}? Nice!
<br><br>
Your favorite language is ${student.progLang}
<br><br>
You used OS like:
<ul>
    <c:forEach var="os" items="${student.operatingSystems}">
        <li>${os}</li>
    </c:forEach>
</ul>

</body>
</html>
