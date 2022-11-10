<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="head.jsp"></jsp:include>
    <title>Title</title>
</head>
<body class="d-flex justify-content-center align-items-center">
<form action="" method="post" class="p-3 bg-light col-11 col-md-6 gap-2">
    <p class="h4">Edite Activetes</p>
    <div>
        <label for="titleUp" class="label-control">Title</label>
        <input type="text" class="form-control" name="titleUp" id="titleUp" value="${actevete.getTitle()}">
        <div class="error"></div>
    </div>
    <div>
        <label for="dateD" class="label-control">date debut</label>
        <input type="date" class="form-control" name="dateDebutUp" id="dateD" value="${actevete.getDate_debut()}">
        <div class="error"></div>
    </div>
    <div>
        <label for="dateFin" class="label-control">Date de fin </label>
        <input class="form-control" type="date" name="dateFinUp" id="dateFin" value="${actevete.getDate_fin()}">
        <div class="error"></div>
    </div>
    <div>
        <label for="dateDI" class="label-control">date debut inscription</label>
        <input type="date" class="form-control" name="dateDIUp" id="dateDI" value="${actevete.getDate_de_participation()}">
        <div class="error"></div>
    </div>
    <div>
        <label for="dateFI" class="label-control">date fin inscription</label>
        <input type="date" class="form-control" name="dateFIUp" id="dateFI" value="${actevete.getDate_fin_participation()}">
        <div class="error"></div>
    </div>
    <div>
        <label for="choixType" class="label-control">Choisir type activite</label>
        <select class="form-select" name="choixTypeUp" id="choixType">
            <c:forEach items="${typeActiveteUp}" var="typeAc">
                <option <c:if test="${typeAc == actevete.getTypeActivité()}" >selected</c:if> value="${typeAc}">${typeAc}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="responsableUp" class="label-control">Choisir Responsable</label>
        <select class="form-select" name="responsableUp" id="responsableUp">
            <c:forEach items="${responsables}" var="responsable">
                <option value="${responsable.getId()}">${responsable.getNom()} ${responsable.getPrenom()}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="descUp" class="label-control">Description</label>
        <input type="text" class="form-control" name="descUp" id="descUp" value="${actevete.getDescription()}">
        <div class="error"></div>
    </div>
    <input type="submit" class="form-control btn btns mt-4" value="Edite">
</form>
</body>
</html>
