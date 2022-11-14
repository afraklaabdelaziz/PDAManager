<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<mvc:resources location="/Asets/" mapping="/Asets/**"></mvc:resources>
<jsp:include page="head.jsp"></jsp:include>
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
