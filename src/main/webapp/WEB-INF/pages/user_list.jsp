<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
    <tr>
        <td><b>name</b></td>
        <td><b>password</b></td>
        <td><b>email</b></td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td><input type="button" value="delete" onclick="window.location='main/delete?id=${user.id}'"/></td>
        </tr>
    </c:forEach>
</table>