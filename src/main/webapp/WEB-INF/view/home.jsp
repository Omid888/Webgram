<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Saeed
  Date: 12/17/2017
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${user.name}</title>
</head>
<body>
<h1>Hello ${user.name}</h1>
<div>
<h2>Home</h2>

    <h4>
        <c:choose>
            <c:when test="${user.posts == null}">
                channel has no any post
            </c:when>
            <c:otherwise>
                <c:forEach items="${user.posts}" var="p">
                    writer: ${p.writerName}
                    <br/>
                    title: ${p.title}
                    <br/>
                    content: ${p.content}
                    <br/>
                    <img src="<c:out value="${p.imageUrl}"/>">
                    <br/>
                    date: ${p.date}
                    <br/>
                    likes: ${p.likes} reads: ${p.reads}
                    <br/>
                    <a href="<c:out value="${p.url}"/>">${p.url}</a>
                    <br/>
                    -----------------------------------------------------
                    <br/>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </h4>

</div>
<div>
    <h2>Channels</h2>
    <h3>
        <c:choose>
            <c:when test="${user.channels == null}">
                you are not join any channels yet!!
            </c:when>
            <c:otherwise>
                <c:forEach items="${user.channels}" var="channel">
                    <li> <a href="<c:out value="/api/channel/${channel.id}"/>">${channel.name}</a></li>
                </c:forEach>
            </c:otherwise>
        </c:choose>

    </h3>
</div>
<span style="color: green;">${message}</span>
<br/>
<p>new channel:</p>
<form:form name="newChannelForm" modelAttribute="channel" action="${pageContext.request.contextPath}/api/channel" method="post">
    name: <form:input id="name" path="name" name="name"/>
    <br/>
    <input type="submit" name="newChannel" value="newChannel" />
</form:form>
<div>
    <form:form name="searchChannel" action="${pageContext.request.contextPath}/api/channel/search" method="get">
        <input type="submit" value="show all channels"/>
    </form:form>
</div>
<a href="/logout">Logout</a>
</body>
</html>
