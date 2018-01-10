<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Saeed
  Date: 12/17/2017
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1>Login</h1>

<script type="text/javascript">
    function validateForm() {
        var username = document.loginForm.username;
        if (username.value == "") {
            alert("Username must not be empty!");
            username.focus();
            return false;
        }

        var password = document.loginForm.password;
        if (password.value == "") {
            alert("Password must not be empty!");
            password.focus();
            return false;
        }
        return true;
    }
</script>

<form:form name="loginForm" modelAttribute="loginUser" action="login" method="post" onsubmit="return validateForm();">
    username: <form:input id="username" path="username" name="username"/>
    <br/>
    password: <form:password id="password" path="password" name="password"/>
    <br/>
    <input type="submit" name="login" value="login" />
</form:form>
<span style="color: darkred;">${message}</span>
<br/>
<a href="/api/signup">Signup</a>
</body>
</html>
