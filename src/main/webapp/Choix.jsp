<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 03/11/2022
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choix du role</title>
</head>
<body>
  <form method="get" action="/PDAManager_war_exploded/register">
    <div class="mb-3">
      <label >Saisir votre role:</label>
      <select name="choose">
        <option  value="1"> Responsable</option>
        <option selected value="2">Participant</option>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</body>
</html>
