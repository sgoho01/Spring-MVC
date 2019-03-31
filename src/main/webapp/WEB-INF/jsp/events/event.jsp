<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>title</title>
</head>
<body>
    <h1>이벤트 목록</h1>
    <h2>${message}</h2>
    <table>
        <tr>
            <th>이름</th>
            <th>시간</th>
        </tr>
        <c:forEach items="${events}" var="event">
            <tr>
                <td>event.name</td>
                <td>event.startDateTime</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
