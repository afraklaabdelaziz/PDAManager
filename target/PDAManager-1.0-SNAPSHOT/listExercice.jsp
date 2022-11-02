<%@ page import="com.example.pdamanager.Entities.Exercice" %>
<%@ page import="java.util.List" %>
l<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 02/11/2022
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
          crossorigin="anonymous"
  />
  <title>Title</title>
</head>
<body>

<ul>
  <% List<Exercice> exercices = (List<Exercice>) request.getAttribute("exercices"); %>
  <% for (Exercice exercice:exercices){%>
  <li><%=exercice.getAnnée()%></li>
  <li><%=exercice.getDate_debut()%></li>
  <li><%=exercice.getDate_fin()%></li>
  <li><%=exercice.getEtatExercice()%></li>
  <%}%>
</ul>

</body>
</html>
