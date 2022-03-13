<%--@elvariable id="customer" type="me.mikholskiy.domains.Customer"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer confirmation</title>
</head>
<body>
First name: <strong>${customer.firstName}</strong>
<br>
Last name: <strong>${customer.lastName}</strong>
<br>
Free passes: <strong>${customer.freePasses}</strong>
<br>
Postal code: <strong>${customer.postalCode}</strong>
</body>
</html>
