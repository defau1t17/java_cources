<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 23.04.2023
  Time: 1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-6">
            <form method="post" action="/registration">
                <div class="mb-2">
                    <input placeholder="name" name="name" type="text" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
                </div>
                <div class="mb-2">
                    <input placeholder="user name" name="userName" type="text" class="form-control"
                           id="exampleInputEmail2"
                           aria-describedby="emailHelp">
                </div>
                <div class="mb-2">
                    <input placeholder="password" name="password" type="password" class="form-control"
                           id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-primary">Continue</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
