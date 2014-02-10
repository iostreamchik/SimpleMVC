<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="">
<html>
<head>
    <title>user accounts</title>
</head>
<body>
<h1>${header_title}</h1>

<jsp:include page="header.jsp"/>

<table border="1">
    <tr>
        <td><b>username</b></td>
        <td><b>password</b></td>
        <td><b>email</b></td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td><input type="button" value="delete" onclick="window.location='users/delete?id=${user.id}'"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>