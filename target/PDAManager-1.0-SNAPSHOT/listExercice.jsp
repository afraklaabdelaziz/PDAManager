<%@ page import="java.util.List" %>
<%@ page import="com.example.pdamanager.Entities.Exercice" %>

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
  <title>ExerciceList</title>
</head>
<body>

<ul>
 <%
     List<Exercice> exercices=(List<Exercice>) request.getAttribute("exercices");
  for (Exercice exercice : exercices ){%>
    <li><%=exercice.getId()%></li>
    <li> Année: <%= exercice.getAnnée() %></li>
    <li>Date Début: <%=exercice.getDate_debut()%></li>
    <li> Date Fin:<%=exercice.getDate_fin()%></li>
    <li>Etat d'exercice: <%=exercice.getEtatExercice()%></li>
    <a href="/updateExercice">update</a>
<%--    <form action="/updateExercice" method="get">--%>
<%--        <input type="hidden" name="id" value="<%=exercice.getId()%>">--%>
<%--        <input type="submit" value="update">--%>
<%--    </form>--%>
</ul>
<%}%>
</body>
</html>
