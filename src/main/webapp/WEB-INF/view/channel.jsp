<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Saeed
  Date: 1/6/2018
  Time: 5:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
              integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy"
              crossorigin="anonymous">
        <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">--%>
        <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
        <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>--%>
        <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>--%>
        <title>Pynii</title>
        <%--<title>${channel.name}</title>--%>
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
            <a href="/api/home">Back to Home Page..</a><br/><br/>

            <div class="card card-body border-light mb-3 ">
                <form:form
                        action="${pageContext.request.contextPath}/api/post?channelId=${channel.id}&channelName=${channel.name}"
                        method="post" modelAttribute="post">
                    title:
                    <form:input path="title"/>
                    <br/>
                    url:
                    <form:input path="url"/>
                    <br/>
                    <input type="submit" name="new post"/>
                </form:form>
                <span style="color: green;">${message}</span>

            </div>
        </div>
        <div class="col-lg-8">
            <h2 style="text-align: center;color: #000000">Channel name:${channel.name}</h2>
            <h4>
                <c:choose>
                    <c:when test="${posts == null}">
                        <h1 style="text-align: center">channel has no posts..</h1>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${posts}" var="p">
                            <div class="card card-body border-light mb-3 " style="font-size: large">

                                <h4 style="text-align: center"><img src="<c:out value="${p.imageUrl}"/>"></h4>
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
                            </div>
                            <br/>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </h4>
        </div>
    </div>
</div>
</body>
</html>
