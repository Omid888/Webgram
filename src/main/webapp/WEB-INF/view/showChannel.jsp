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
<head>
    <title>search result</title>
</head>
<body>
<div>
    <h2>Channels</h2>
    <h3>
        <c:choose>
            <c:when test="${channels == null}">
                no result
            </c:when>
            <c:otherwise>
                <c:forEach items="${channels}" var="channel">
                    <li>${channel.name} by ${channel.creator.name} [<a href="<c:out value="/api/channel/${channel.id}/join"/>">join</a>] </li>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </h3>
</div>
<a href="/api/home">home</a>
</body>
</html>
