<%@ page import="com.example.servletexcercise.domain.member.MemberRepository" %>
<%@ page import="com.example.servletexcercise.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: chansoo
  Date: 2023/09/26
  Time: 1:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();

    String userName = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(userName, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id = <%=member.getId()%>
    </li>
    <li>username = <%=member.getUsername()%>
    </li>
    <li>age = <%=member.getAge()%>
    </li>
</ul>
<a href="/index.html">메인</a>
</a>
</body>
</html>
