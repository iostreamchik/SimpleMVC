<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table>
    <form:form action="users/add" modelAttribute="user" method="post">
        <tr>
            <td>
                <label for="usernameInput">Username</label>
            </td>
            <td>
                <form:input path="username" id="usernameInput"/>
                <form:errors path="username" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="passwordInput">Password</label>
            </td>
            <td>
                <form:input path="password" id="passwordInput"/>
                <form:errors path="password" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="emailInput">Email</label>
            </td>
            <td>
                <form:input path="email" id="emailInput"/>
                <form:errors path="email" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <input type="submit" value="add user"/>
        </tr>
    </form:form>
</table>
</body>
</html>
