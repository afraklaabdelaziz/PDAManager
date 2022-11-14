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
<p class="h4">List Activites</p>
<div class="btn btns" data-bs-toggle="modal" href="#addActivete">Ajouter Activite</div>
</div>

    <div class="d-flex flex-wrap gap-5">
   <c:forEach items="${activetes}" var="activete">
    <div class="activite position-relative">
        <p class="h5 nameClass mt-2">Type activité : ${activete.getTypeActivité()}</p>
        <p> <span class="fas fa-users"></span> Date : ${activete.getDate_debut()} </p>
        <p> <span class="fas fa-users"></span> Date : ${activete.getDate_debut()} </p>
        <p> <span class="fas fa-users"></span> Date : ${user.getNom()} </p>
        <a href="/PDAManager_war_exploded/updateActivete?id=${activete.getId()}"><i class="fas fa-edit edite"></i></a>
    </div>
    </c:forEach>
</div>


<!-- form add  -->
<div class="modal fade" id="addActivete">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <form action="/PDAManager_war_exploded/listActivetes" method="post" class="form-group w-100">
                    <p class="h4">Ajouter activite</p>
                    <div>
                        <label for="title" class="label-control">Title</label>
                        <input type="text" class="form-control" name="title" id="title">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="dateD" class="label-control">date debut</label>
                        <input type="date" class="form-control" name="dateDebut" id="dateD">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="dateFin" class="label-control">Date de fin </label>
                        <input class="form-control" type="date" name="dateFin" id="dateFin">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="dateDI" class="label-control">date debut inscription</label>
                        <input type="date" class="form-control" name="dateDI" id="dateDI">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="dateFI" class="label-control">date fin inscription</label>
                        <input type="date" class="form-control" name="dateFI" id="dateFI">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="choixType" class="label-control">Choisir type activite</label>
                        <select class="form-select" name="choixType" id="choixType">
                            <c:forEach items="${typeActivete}" var="typeAc">
                                <option value="${typeAc}">${typeAc}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label for="exrcice" class="label-control" >Choisir type activite</label>
                        <select class="form-select" size="3" name="exercices" multiple="multiple" id="exrcice">
                            <c:forEach items="${exercices}" var="exercice">
                                <option value="${exercice.getId()}">${exercice.getNom()}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label for="responsable" class="label-control">Choisir Responsable</label>
                        <select class="form-select" name="responsable" id="responsable">
                            <c:forEach items="${responsables}" var="responsable">
                                <option value="${responsable.getId()}">${responsable.getNom()} ${responsable.getPrenom()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label for="desc" class="label-control">Description</label>
                        <input type="text" class="form-control" name="desc" id="desc">
                        <div class="error"></div>
                    </div>
                    <input type="submit" class="form-control btn btns mt-4" value="Ajouter">
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<!-- end form -->


<%--<div class="modal fade" id="addActive" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">--%>
<%--    <div class="modal-dialog modal-dialog-centered" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true"></span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <form method="post" name="FormRegister" class="flex justify-content-center ms-5 me-5 w-75">--%>
<%--                    <div class="mb-3">--%>
<%--                        <label class="form-label">date debut</label>--%>
<%--                        <input type="date" class="form-control" name="dateDebut" >--%>
<%--                    </div>--%>
<%--                    <div class="mb-3">--%>
<%--                        <label class="form-label">date fin </label>--%>
<%--                        <input type="date" class="form-control" name="dateFin" >--%>
<%--                    </div>--%>
<%--                    <div class="mb-3">--%>
<%--                        <label  class="form-label">date debut inscription</label>--%>
<%--                        <input type="date" class="form-control" name="dateDI" >--%>
<%--                    </div>--%>
<%--                    <div class="mb-3">--%>
<%--                        <label class="form-label"> date fin inscription</label>--%>
<%--                        <input type="date" class="form-control" name="dateFI" >--%>
<%--                    </div>--%>

<%--                    <div class="mb-3">--%>
<%--                        <select name="choixType">--%>
<%--                        <c:forEach items="${typeActivete}" var="typeAc">--%>
<%--                            <option value="${typeAc}">${typeAc}</option>--%>
<%--                        </c:forEach>--%>
<%--                        </select>--%>
<%--                    </div>--%>

<%--                    <div class="mb-3">--%>

<%--                        <label  class="form-label">desciption</label>--%>
<%--                        <input type="text" class="form-control" name="desc">--%>
<%--                    </div>--%>
<%--                    <button type="submit" class="btn btn-primary">Ajouter</button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<!-- JavaScript Bundle with Popper -->--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>--%>
<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>--%>

</body>
</html>
