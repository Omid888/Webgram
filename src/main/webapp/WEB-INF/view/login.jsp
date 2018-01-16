<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--&lt;%&ndash;--%>
<%--Created by IntelliJ IDEA.--%>
<%--User: Saeed--%>
<%--Date: 12/17/2017--%>
<%--Time: 2:30 PM--%>
<%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--<title>Login Page</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Login</h1>--%>

<%--<script type="text/javascript">--%>
<%--function validateForm() {--%>
<%--var username = document.loginForm.username;--%>
<%--if (username.value == "") {--%>
<%--alert("Username must not be empty!");--%>
<%--username.focus();--%>
<%--return false;--%>
<%--}--%>

<%--var password = document.loginForm.password;--%>
<%--if (password.value == "") {--%>
<%--alert("Password must not be empty!");--%>
<%--password.focus();--%>
<%--return false;--%>
<%--}--%>
<%--return true;--%>
<%--}--%>
<%--</script>--%>

<%--<form:form name="loginForm" modelAttribute="loginUser" action="login" method="post" onsubmit="return validateForm();">--%>
<%--username: <form:input id="username" path="username" name="username"/>--%>
<%--<br/>--%>
<%--password: <form:password id="password" path="password" name="password"/>--%>
<%--<br/>--%>
<%--<input type="submit" name="login" value="login" />--%>
<%--</form:form>--%>
<%--<span style="color: darkredyy;">${message}</span>--%>
<%--<br/>--%>
<%--<a href="/api/signup">Signup</a>--%>
<%--</body>--%>
<%--</html>--%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head><title>Pynii</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="icon" href="/resources/favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
          integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
            integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
            crossorigin="anonymous"></script>
    <style>
        body {
            background-image: url("/resources/background.png");
        }
    </style>
</head>
<body>
<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Sign In</div>
            </div>
        </div>

        <div style="padding-top:30px" class="panel-body">

            <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

            <form:form name="loginForm" modelAttribute="loginUser" action="login" method="post" id="loginform"
                       class="form-horizontal" role="form">

                <div style="margin-bottom: 25px" class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="login-username" type="text" class="form-control" name="username" value=""
                           placeholder="username or email" required autofocus>
                </div>

                <div style="margin-bottom: 25px" class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="login-password" type="password" class="form-control" name="password"
                           placeholder="password" required>
                </div>

                <span style="color: darkred;">${message}</span>

                <div style="margin-top:10px" class="form-group">
                    <!-- Button -->
                    <div class="col-sm-12 controls">
                        <input id="btn-login" class="btn btn-success" type="submit" name="login" value="Login"/>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-md-12 control">
                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                            Don't have an account?
                            <a href="/api/signup">
                                Sign Up Here
                            </a>
                        </div>
                    </div>
                </div>
            </form:form>


        </div>
    </div>
</div>


</body>
</html>