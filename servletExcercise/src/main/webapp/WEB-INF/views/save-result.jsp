<%@ page import="com.example.servletexcercise.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: chansoo
  Date: 2023/10/01
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
<%--    <li>id = <%=((Member) request.getAttribute("member")).getId()%>--%>
<%--    </li>--%>
<%--    <li>username = <%=((Member) request.getAttribute("member")).getUsername()%>--%>
<%--    </li>--%>
<%--    <li>age = <%=((Member) request.getAttribute("member")).getAge()%>--%>
<%--    </li>--%>
    <li>id = ${member.id}</li>
    <li>username = ${member.username}</li>
    <li>age = ${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</a>
</body>
</html>
