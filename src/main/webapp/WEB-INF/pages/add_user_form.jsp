<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <form:form action="main" modelAttribute="user">
        <tr>
            <td>
                <label for="nameInput">Username</label>
            </td>
            <td>
                <form:input path="name" id="nameInput"/>
                <form:errors path="name" cssClass="error"/>
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
