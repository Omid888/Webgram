<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Saeed
  Date: 12/17/2017
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html">
    <title>Signup</title>
</head>
<body>
<h1>SignUp Form</h1>

<form:form action="signup" method="post" modelAttribute="signupUser">
    name: <form:input path="name"/>
    <br/>
    username: <form:input path="username"/>
    <br/>
    password: <form:password path="password"/>
    <br/>
    <input type="submit" name="signup" />
</form:form>
<span style="color: darkred;">${message}</span>
<br/>
<a href="/login">login</a>
</body>
</html>
