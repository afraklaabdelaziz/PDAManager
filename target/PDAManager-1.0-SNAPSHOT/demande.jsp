<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 11/14/2022
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"></jsp:include>

    <title>Title</title>
</head>
<body>
<div>
    <jsp:include page="sideRes.jsp"></jsp:include>
<ul>
    <c:forEach items="${demandesRes}" var="demande">
        <li>${demande.getMessage()}</li>
         <form method="post">
             <input type="hidden" name="email" value="${demande.getParticipant().getEmail()}">
             <input type="hidden" name="id" value="${demande.getId()}">
             <button value="refuse" type="submit" name="statut">Refuse</button>
             <button value="accept" type="submit" name="statut">Accepte</button>
         </form>
    </c:forEach>
</ul>
    <div>
</body>
</html>
