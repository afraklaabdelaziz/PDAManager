<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 01/11/2022
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="Asets/css/style.css">
    <script src="https://kit.fontawesome.com/a523390b1d.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <title>Title</title>
</head>
<body>
<div>
<aside id="aside" class="side-bar col-sm-2 col-md-3 col-lg-2 d-flex flex-column gap-5">
    <div class="text-center">
        <p class="fw-bold h5 mt-2 name d-md-inline d-none">Gestion d'école</p>
        <div class="d-flex flex-column align-items-center mt-5">
            <img class="rounded-circle w-50 img d-none d-md-inline" src="abdelaziz.jpg" alt="admin">
            <span class="text-info name d-none d-md-inline  name">admin</span>
        </div>
    </div>

    <ul class="list-group">

        <li class="list-group-item">
            <a data-bs-toggle="list" class="btn mt-2 text-light d-flex" href="#">
                <i class="fas fa-home pe-3"></i>
                <span class="fw-bold name d-none d-md-inline">Home</span>
            </a>
        </li>


        <li class="list-group-item">
            <a data-bs-toggle="list" class="btn mt-2 text-light d-flex" href="#">
                <i class="fas fa-graduation-cap pe-3"></i>
                <span class="fw-bold text-white name d-none d-md-inline">Etudiant</span>
            </a>
        </li>




        <li class="list-group-item">
            <a data-bs-toggle="list" class="btn mt-5 text-light d-flex" href="#">
                <i class="fas fa-right-from-bracket pe-3"></i>
                <span class="fw-bold name d-none d-md-inline">Logout</span>
            </a>
        </li>

    </ul>
</aside>


<div class="px-1 active-cont">
    <header class="position-sticky bg-light top-0 w-100">
        <i class="btn fas fa-hand-point-right"></i>
    </header>
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
