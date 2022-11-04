<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 10/23/2022
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>jkdsgjh</h1>

<h1>Bien venu : ${sessionScope.name} ${sessionScope.prenom}</h1>

<ul>
    <li>Nom : ${user.nom}</li>
    <li>Prenom : ${user.prenom}</li>
    <li>Email : ${user.email}</li>
    <li>Phone : ${user.phone}</li>
    <li>Role : ${sessionScope.roleUser}</li>
</ul>
</body>
</html>
