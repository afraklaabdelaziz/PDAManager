<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 11/14/2022
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach items="${demandesRes}" var="demande">
        <li>${demande.getMessage()}</li>
         <form method="post">
             <input type="hidden" name="id" value="${demande.getParticipant().getId()}">
             <button value="refuse" type="submit" name="statut">Refuse</button>
             <button value="accept" type="submit" name="statut">Accepte</button>
         </form>
    </c:forEach>
</ul>
</body>
</html>
