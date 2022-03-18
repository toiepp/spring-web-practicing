<%--
  User: mikholskiyivan
  Date: 3/17/22 10:55 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of customers</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/static/css/style.css">
</head>
<body>
<div class="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
    <div class="container">
        <div id="content">
            <input type="button" value="Add customer"
                   onclick="window.location.href='customer-creation-form'; return false;"/>
            <input type="button" value="Sort customers"
                   onclick="window.location.href='list/sort'; return false;">
            <table>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email</th>
                </tr>
                <jsp:useBean id="list_of_customers" scope="request" type="java.util.List"/>
                <c:forEach var="customer" items="${list_of_customers}">

                    <c:url var="updateLink" value="/customer/update">
                        <c:param name="customer-id" value="${customer.id}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customer-id" value="${customer.id}"/>
                    </c:url>
                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td><a href="${updateLink}">Update</a></td>
                        <td><a href="${deleteLink}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
