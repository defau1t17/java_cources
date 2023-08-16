<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 23.04.2023
  Time: 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jst" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-6">
            <form method="post" action="/calc">
                <div class="mb-2">
                    <input placeholder="value 1" name="num1" type="text" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
                </div>
                <div class="mb-2">
                    <input placeholder="value 2" name="num2" type="text" class="form-control" id="exampleInputEmail2"
                           aria-describedby="emailHelp">
                </div>

                <div class="form-floating">
                    <select name="operation" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                        <option selected disabled>+</option>
                        <option value="sum">+</option>
                        <option value="diff">-</option>
                        <option value="multiply">*</option>
                        <option value="div">/</option>
                    </select>
                </div>


                <jst:if test="${sessionScope.result == null}">
                    <p>Result = </p>
                </jst:if>

                <jst:if test="${sessionScope.result != null}">
                    <p>Result = ${sessionScope.result}</p>
                </jst:if>
                <button type="submit" class="btn btn-primary">Calculate</button>

            </form>
        </div>
    </div>
</div>


</body>
</html>
