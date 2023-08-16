<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 23.04.2023
  Time: 17:10
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

<div class="container"  >
    <div class="row justify-content-center">
        <div class="col-6">
            <ul  class="list-group">
                <jst:if test="${listOfOperations == null}">


                </jst:if>

                <jst:if test="${listOfOperations != null}">
                    <jst:forEach items="${listOfOperations}" var="elem">
                        <li class="list-group-item">${elem}</li>
                    </jst:forEach>
                </jst:if>


            </ul>
        </div>
    </div>


</div>

</body>
</html>
