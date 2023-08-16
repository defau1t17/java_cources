<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 15.05.2023
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<%--<form action="/user/registration">--%>
<%--    <input type="text" name="name" placeholder="name">--%>
<%--    <br>--%>
<%--    <p>${name}</p>--%>
<%--    <input type="text" name="username" placeholder="user name">--%>
<%--    <br>--%>
<%--    <p>${username}</p>--%>

<%--    <input type="password" name="password" placeholder="Password">--%>
<%--    <br>--%>
<%--    <p>${password}</p>--%>
<%--    <button>Submit</button>--%>

<%--</form>--%>


<s:form method="post" action="/user/registration" modelAttribute="newUser">
    <s:input path="name" placeholder="name"/>
    <s:errors path="name"/>
    <br>
    <s:input path="username" placeholder="username"/>
    <s:errors path="username"/>
    <br>

    <s:input path="password" placeholder="password"/>
    <s:errors path="password"/>
    <br>

    <s:input path="city" placeholder="city"/>
    <s:errors path="city"/>
    <br>

    <s:input path="street" placeholder="street"/>
    <s:errors path="street"/>

    <s:button>Submit</s:button>

</s:form>
</body>
</html>
