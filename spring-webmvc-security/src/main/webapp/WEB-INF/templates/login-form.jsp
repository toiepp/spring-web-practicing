<%--
  User: mikholskiyivan
  Date: 3/23/22 11:02 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <style>
      .form {
        align-content:  center;
        vertical-align: center;
        display:        inline-block;
        border:         black 1px solid;
        padding:        10px;
      }

      .error {
        padding:          10px;
        border:           red 1px solid;
        background-color: rgba(255, 0, 0, 0.24);
      }

      .logout-msg {
        padding:          10px;
        border:           green 1px solid;
        background-color: rgba(114, 255, 66, 0.19);
      }
    </style>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/authenticate-user"
      method="post"
      cssClass="form">
    <h3>Log in</h3>
    <c:if test="${param.error != null}">
        <p class="error">Seems like you not authorized! :(</p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p class="logout-msg">See you later</p>
    </c:if>
    <p><label><input type="text" name="username" placeholder="Username"></label></p>
    <p><label><input type="password" name="password" placeholder="Password"></label></p>
    <input type="submit" value="Login">
</form:form>
</body>
</html>
