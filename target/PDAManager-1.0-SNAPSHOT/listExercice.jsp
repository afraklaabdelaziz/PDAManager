<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<mvc:resources location="/Asets/" mapping="/Asets/**"></mvc:resources>
<jsp:include page="head.jsp"></jsp:include>
<title>Title</title>
</head>
<body>
<div>
    <jsp:include page="side.jsp"></jsp:include>
    <div class="d-flex justify-content-between mb-4">
        <p class="h4">List Exercices</p>
        <div class="btn btns" data-bs-toggle="modal" href="#addActivete">Ajouter Exercice</div>
    </div>

    <div class="d-flex flex-wrap gap-5">
        <c:forEach items="${exercices}" var="exercice">
            <div class="activite position-relative">
                <p class="h5 nameClass mt-2">Type activité : ${exercice.getNom()}</p>
                <p> <span class="fas fa-users"></span> Date : ${exercice.getDate_debut()} </p>
                <p> <span class="fas fa-users"></span> Date : ${exercice.getDate_fin()} </p>
                <p> <span class="fas fa-users"></span> Date : ${exercice.getAnnée()} </p>
                <p> <span class="fas fa-users"></span> Date : ${exercice.getEtatExercice()} </p>
                <a href="/PDAManager_war_exploded/updateExercice?id=${exercice.getId()}"><i class="fas fa-edit edite"></i></a>
            </div>
        </c:forEach>
    </div>


    <!-- form add  -->
    <div class="modal fade" id="addActivete">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <form action="/PDAManager_war_exploded/Exercice" method="post" class="form-group w-100">
                        <p class="h4">Ajouter activite</p>
                        <div>
                            <label for="title" class="label-control">Nom</label>
                            <input type="text" class="form-control" name="nom" id="title">
                            <div class="error"></div>
                        </div>
                        <div>
                            <label for="dateD" class="label-control">date debut</label>
                            <input type="date" class="form-control" name="debut" id="dateD">
                            <div class="error"></div>
                        </div>
                        <div>
                            <label for="dateFin" class="label-control">Date de fin </label>
                            <input class="form-control" type="date" name="fin" id="dateFin">
                            <div class="error"></div>
                        </div>
                        <div>
                            <label for="dateDI" class="label-control">Année</label>
                            <input type="date" class="form-control" name="anne" id="dateDI">
                            <div class="error"></div>
                        </div>
                        <input type="submit" class="form-control btn btns mt-4" value="Ajouter">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
