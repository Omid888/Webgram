<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--&lt;%&ndash;--%>
<%--Created by IntelliJ IDEA.--%>
<%--User: Saeed--%>
<%--Date: 12/17/2017--%>
<%--Time: 7:44 PM--%>
<%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--<title>${user.name}</title>--%>
<%--<meta charset="utf-8">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>

<%--<link rel="icon" href="https://cdn4.iconfinder.com/data/icons/security-soft-1/512/register_log_in_user_login_session_authorize_open_account_access_key-512.png">--%>
<%--<!-- Bootstrap CSS -->--%>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"--%>
<%--integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">--%>
<%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"--%>
<%--integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"--%>
<%--crossorigin="anonymous"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"--%>
<%--integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"--%>
<%--crossorigin="anonymous"></script>--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"--%>
<%--integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"--%>
<%--crossorigin="anonymous"></script>--%>
<%--</head>--%>

<%--<body>--%>

<%--<h1 class="text-center">Hello ${user.name}</h1>--%>
<%--<div>--%>
<%--<h2>Home</h2>--%>

<%--<h4>--%>
<%--<c:choose>--%>
<%--<c:when test="${user.posts == null}">--%>
<%--channel has no any post--%>
<%--</c:when>--%>
<%--<c:otherwise>--%>
<%--<c:forEach items="${user.posts}" var="p">--%>
<%--writer: ${p.writerName}--%>
<%--<br/>--%>
<%--title: ${p.title}--%>
<%--<br/>--%>
<%--content: ${p.content}--%>
<%--<br/>--%>
<%--<img src="<c:out value="${p.imageUrl}"/>">--%>
<%--<br/>--%>
<%--date: ${p.date}--%>
<%--<br/>--%>
<%--likes: ${p.likes} reads: ${p.reads}--%>
<%--<br/>--%>
<%--<a href="<c:out value="${p.url}"/>">${p.url}</a>--%>
<%--<br/>--%>
<%---------------------------------------------------------%>
<%--<br/>--%>
<%--</c:forEach>--%>
<%--</c:otherwise>--%>
<%--</c:choose>--%>
<%--</h4>--%>

<%--</div>--%>
<%--<div>--%>
<%--<h2>Channels</h2>--%>
<%--<h3>--%>
<%--<c:choose>--%>
<%--<c:when test="${user.channels == null}">--%>
<%--you are not join any channels yet!!--%>
<%--</c:when>--%>
<%--<c:otherwise>--%>
<%--<c:forEach items="${user.channels}" var="channel">--%>
<%--<li> <a href="<c:out value="/api/channel/${channel.id}"/>">${channel.name}</a></li>--%>
<%--</c:forEach>--%>
<%--</c:otherwise>--%>
<%--</c:choose>--%>

<%--</h3>--%>
<%--</div>--%>
<%--<span style="color: green;">${message}</span>--%>
<%--<br/>--%>
<%--<p>new channel:</p>--%>
<%--<form:form name="newChannelForm" modelAttribute="channel" action="${pageContext.request.contextPath}/api/channel" method="post">--%>
<%--name: <form:input id="name" path="name" name="name"/>--%>
<%--<br/>--%>
<%--<input type="submit" name="newChannel" value="newChannel" />--%>
<%--</form:form>--%>
<%--<a href="/logout">Logout</a>--%>
<%--</body>--%>
<%--</html>--%>


<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <style>
        body {
            background-image: url("/resources/background.png");
        }

        @font-face {
            font-family: Bangers;
            src: url("/resources/Bangers-Regular.ttf");
        }

        @font-face {
            font-family: Sofia;
            src: url("/resources/Sofia/Sofia-Regular.ttf");
        }

        @font-face {
            font-family: Cinzel Decorative;
            src: url("/resources/Cinzel_Decorative/CinzelDecorative-Regular.ttf");
        }
    </style>
    <link rel="icon" href="/resources/favicon.png">

    <%--<link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>--%>
    <%--<link href='https://fonts.googleapis.com/css?family=Bangers' rel='stylesheet'>--%>
    <%--<link href='https://fonts.googleapis.com/css?family=Cinzel Decorative' rel='stylesheet'>--%>


    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
          integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>--%>
    <title>Pynii</title>
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <h2 style="font-family: 'Sofia';">Welcome to <span style="font-family: Bangers">Pynii</span> social network</h2>
        <p style="font-family: 'Cinzel Decorative';font-weight: 600;">Feel free to share your web browsing..</p>
    </div>
</div>


<div class="container">
    <div class="row">
        <div class="col-lg-4">
            <div class="card card-body border-light mb-3 ">
                <h4 style="font-family: 'Serif'">Hi ${user.name},<a style="color: darkolivegreen;font-size: large"
                                                                    href="/logout">logout</a></h4>
            </div>

            <div class="card card-body border-light mb-3 ">

                <h5>your channels:</h5>
                <c:choose>
                    <c:when test="${user.channels == null}">
                        <h5>No channels found, Join one if you wish..</h5>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${user.channels}" var="channel">
                            <li><a href="<c:out value="/api/channel/${channel.id}"/>">${channel.name}</a></li>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>

                <br/>

            </div>
            <div class="card card-body border-light mb-3 ">

                <h5>you can create one..</h5>
                <form:form name="newChannelForm" modelAttribute="channel"
                           action="${pageContext.request.contextPath}/api/channel" method="post">
                    Enter a name: <form:input id="name" path="name" name="name"/>
                    <br/>
                    <input type="submit" name="newChannel" value="newChannel"/>
                </form:form>
            </div>
        </div>
        <div class="col-lg-8" id="target">

            <h4 style="text-align: left;font-family: 'Serif';font-size: large">
                <c:choose>
                    <c:when test="${user.posts == null}">
                        <h1 style="text-align: center;font-family: 'Serif'">Your feed is empty..</h1>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${user.posts}" var="p">
                            <div class="card card-body border-light mb-3 ">

                                <h4 style="text-align: center"><img src="<c:out value="${p.imageUrl}"/>"></h4>
                                <br/>
                                <a href="<c:out value="/api/channel/${p.channelId}"/>">${p.channelName}</a>
                                <br/>
                                writer: ${p.writerName}
                                <br/>
                                title: ${p.title}
                                <br/>
                                caption: ${p.content}
                                <br/>
                                date: ${p.date}
                                <br/>
                                likes: ${p.likes} reads: ${p.reads}
                                <br/>
                                <a href="<c:out value="${p.url}"/>">${p.url}</a>
                                <br/>
                                <a href="<c:out value="/api/post/${p.id}/like"/>">like</a>
                            </div>
                            <br/>

                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </h4>
        </div>
        <%--<div class="col-lg-3">--%>


        <%--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut--%>
        <%--labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi--%>
        <%--ut aliquip ex--%>
        <%--ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu--%>
        <%--fugiat nulla--%>
        <%--pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim--%>
        <%--id est--%>
        <%--laborum.--%>
        <%--Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et--%>
        <%--dolore magna--%>
        <%--aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo--%>
        <%--consequat.--%>
        <%--Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.--%>
        <%--Excepteur--%>
        <%--sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.--%>

        <%--Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et--%>
        <%--dolore magna--%>
        <%--aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo--%>
        <%--consequat.--%>
        <%--Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.--%>
        <%--Excepteur--%>
        <%--sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.--%>
        <%--</p>--%>
        <%--</div>--%>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
        integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
        crossorigin="anonymous"></script>
<script>
    $(window).scroll(function () {
        if ($(window).scrollTop() + $(window).height() == $(document).height()) {
            //alert("bottom!");
            $.ajax({
                type: "get",
                url: "/api/home/post",
                data: {
                    start: "1",
                    size: "1"
                },
                success: function (msg) {

                    // This needs to be implemented..

                }
            });
        }
    });</script>
</body>
</html>
