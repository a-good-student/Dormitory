<%--
  Created by IntelliJ IDEA.
  User: 贺潇峰
  Date: 2022/1/16
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销</title>
</head>
<body>
<%
    response.setHeader("refresh","2;URL=../index.jsp");
    session.invalidate();
%>
<h3>您已成功注销，两秒后跳转回登录页面</h3>
</body>
</html>
