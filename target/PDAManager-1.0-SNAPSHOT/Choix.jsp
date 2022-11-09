<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 03/11/2022
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<mvc:resources location="/Asets/" mapping="/Asets/**"></mvc:resources>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="Asets/css/style.css">
    <script src="https://kit.fontawesome.com/a523390b1d.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <title>Choix du role</title>
</head>
<body>
  <div class="d-flex flex-column align-items-center justify-content-center h-100 gap-4">
      <h4>vous ete :</h4>
      <div class="d-flex justify-content-center gap-5">
          <a href="/PDAManager_war_exploded/register?choose=1" class="d-flex flex-column align-items-center col-12 col-md-6"><img class="rounded" src='<c:url value="/Asets/Images/responsable.png"></c:url>' /> <span>Responsable</span>  </a>
          <a href="/PDAManager_war_exploded/register?choose=2" class="d-flex flex-column align-items-center col-12 col-md-6"><img class="rounded" src='<c:url value="/Asets/Images/participant.png"></c:url>' /> <span>Participant</span> </a>
      </div>
      <h5>Vous avez deja un compte</h5>
      <a href="/PDAManager_war_exploded/login" class="btns p-1">Login</a>
  </div>
</body>
</html>
