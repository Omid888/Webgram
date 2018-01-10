<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Saeed
  Date: 1/10/2018
  Time: 7:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
</head>
<body>
<div>
    <h4>
        <c:choose>
            <c:when test="${post == null}">
                <span style="color: red;">${message}</span>
            </c:when>
            <c:otherwise>
                writer: ${post.writerName}
                <br/>
                title: ${post.title}
                <br/>
                content: ${post.content}
                <br/>
                <img src="<c:out value="${post.imageUrl}"/>">
                <br/>
                date: ${post.date}
                <br/>
                likes: ${post.likes} reads: ${post.reads}
                <br/>
                <a href="<c:out value="${post.url}"/>">${post.url}</a>
                <br/>
                <span style="color: green;">${message}</span>
                <br/>
            </c:otherwise>
        </c:choose>
    </h4>
</div>
<a href="/api/channel/${channel.id}">back to ${channel.name}</a>
</body>
</html>
