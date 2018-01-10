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
    <title>${channel.name}</title>
</head>
<body>
<div>
    <h4>
        <c:choose>
            <c:when test="${posts == null}">
                channel has no any post
            </c:when>
            <c:otherwise>
                <c:forEach items="${posts}" var="p">
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
<form:form action="${pageContext.request.contextPath}/api/post?channelId=${channel.id}&channelName=${channel.name}"
           method="post" modelAttribute="post">
    title: <form:input path="title"/>
    <br/>
    url: <form:input path="url"/>
    <br/>
    <input type="submit" name="new post" />
</form:form>
<span style="color: green;">${message}</span>
<a href="/api/home">Home</a>
</body>
</html>
