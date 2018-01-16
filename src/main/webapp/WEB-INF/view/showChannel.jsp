<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Saeed
  Date: 1/11/2018
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

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

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
      integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">

<title>search result</title>
<body>
<div style="text-align: center;">
    <h2>All Channels</h2>
    <h5>
        <c:choose>
            <c:when test="${channels == null}">
                no result
            </c:when>
            <c:otherwise>

                <div class="row">
                    <div class="col-lg-4">
                    </div>
                    <div class="col-lg-4">
                        <c:forEach items="${channels}" var="channel">

                            <div class="card card-body border-light mb-3 ">

                                <h3>${channel.name}</h3>
                                <br/>
                                <br/>
                                Creator : ${channel.creator.name}
                                <br/>
                                Posts number : ${channel.postsNumber}
                                <br/>
                                Members: ${channel.members}
                                <br/>
                                <br/>

                                <c:choose>
                                    <c:when test="${channel.joined}">
                                        <a href="<c:out value="/api/channel/${channel.id}"/>">Show</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="<c:out value="/api/channel/${channel.id}/join"/>">join</a>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                            <br/>

                        </c:forEach>

                        <a href="/api/home">home</a>

                    </div>
                    <div class="col-lg-4">
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </h5>
</div>

</body>
</html>
