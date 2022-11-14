<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="head.jsp"></jsp:include>
<title>Title</title>
</head>
<body class="d-flex justify-content-center align-items-center">
<form action="" method="post" class="p-3 bg-light col-11 col-md-6 gap-2">
  <p class="h4">Edite Exercices</p>
  <div>
    <label for="titleUp" class="label-control">Title</label>
    <input type="text" class="form-control" name="nome" id="titleUp" value="${exercice.getNom()}">
    <div class="error"></div>
  </div>
  <div>
    <label for="dateD" class="label-control">date debut</label>
    <input type="date" class="form-control" name="debutt" id="dateD" value="${exercice.getDate_debut()}">
    <div class="error"></div>
  </div>
  <div>
    <label for="dateFin" class="label-control">Date de fin </label>
    <input class="form-control" type="date" name="finn" id="dateFin" value="${exercice.getDate_fin()}">
    <div class="error"></div>
  </div>
  <div>
    <label for="dateFI" class="label-control">date fin inscription</label>
    <input type="date" class="form-control" name="annee" id="dateFI" value="${exercice.getAnnée()}">
    <div class="error"></div>
  </div>
  <div>
    <label for="choixType" class="label-control">Choisir type activite</label>
    <select class="form-select" name="etatt" id="choixType">
      <c:forEach items="${etatExercices}" var="typeAc">
        <option <c:if test="${typeAc ==exercice.getEtatExercice()}" >selected</c:if> value="${typeAc}">${typeAc}</option>
      </c:forEach>
    </select>
  </div>
  <input type="submit" class="form-control btn btns mt-4" value="Edite">
</form>
</body>
</html>
