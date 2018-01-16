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


    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
          integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">

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
                <a style="color: darkolivegreen;font-size: large" href="/api/channel/search">See All Other Channels</a>

            </div>
            <div class="card card-body border-light mb-3 ">

                <h5>you can create one..</h5>
                <br/>
                <form:form name="newChannelForm" modelAttribute="channel"
                           action="${pageContext.request.contextPath}/api/channel" method="post">
                    Enter a name:&nbsp; <form:input id="name" path="name" name="name"/>
                    <br/>
                    <br/>
                    <input style="color: green" type="submit" name="newChannel" value="new channel"/>
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

                                <h4 style="text-align: center"><img style="max-height: 500px; max-width: 800px" src="<c:out value="${p.imageUrl}"/> " ></h4>
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
    $(document).ready(function () {
        var lastrecievednumber = 10;
        $(window).scroll(function () {
            if ($(window).scrollTop() + $(window).height() == $(document).height()) {
                $.ajax({
                    type: "get",
                    url: "/api/home/post",
                    data: {
                        start: lastrecievednumber,
                        size: 10
                    },
                    success: function (msg) {
//                    alert(msg[0].content);
//                    $('#target').append(msg[0].content);
                        for (i = 0; i < msg.length; i++) {
                            html = '<div class="card card-body border-light mb-3 ">\n' +
                                '\n' +
                                '<h4 style="text-align: center"><img style="max-height: 500px; max-width: 800px" src="' + msg[i].imageUrl + '"/>"></h4>\n' +
                                '<br/>\n' +
                                'writer: ' + msg[i].writerName + '\n' +
                                '<br/>\n' +
                                'title: ' + msg[i].title + '\n' +
                                '<br/>\n' +
                                'caption: ' + msg[i].content + '\n' +
                                '<br/>\n' +
                                'date: ' + msg[i].date + '\n' +
                                '<br/>\n' +
                                'likes: ' + msg[i].likes + ' reads: ' + msg[i].reads + '\n' +
                                '<br/>\n' +
                                '<a href="' + msg[i].url + '">' + msg[i].url + '</a>\n' +
                                '<br/>\n' +
                                '</div>\n' +
                                '<br/>';
                            $('#target').append(html);
                            lastrecievednumber += 10;
                        }

                    }
                });
            }
        });
    });
</script>
</body>
</html>
