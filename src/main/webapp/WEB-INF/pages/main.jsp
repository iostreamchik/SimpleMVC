<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="">
<html>
<head>
    <title>user accounts</title>
</head>
<body>
<h1>${header_title}</h1>

<jsp:include page="add_user_form.jsp"/>
<c:import url="/main/userList"/>

</body>
</html>