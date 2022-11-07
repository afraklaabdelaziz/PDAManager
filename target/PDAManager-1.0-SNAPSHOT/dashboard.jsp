<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 11/6/2022
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="Asets/css/style.css">
    <script src="https://kit.fontawesome.com/a523390b1d.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <title>Title</title>
</head>
<body>
    <header class="position-sticky top-0 w-100 bg-light">
        <i class="btn fas fa-hand-point-right"></i>
    </header>

    <div class="d-flex flex-wrap gap-5 m-4">
        <c:forEach items="${activetes}" var="activete">
            <div class="activite">
                <p class="h5 nameClass mt-2">Type activité : ${activete.getTypeActivité()}</p>
                <p class="text-success"> <span class="fas fa-users"></span> Etat Activité : ${activete.getEtatActivité()}</p>
                <p> <span class="fas fa-users"></span> Responsable : ${activete.getResponsable().getNom()} ${activete.getResponsable().getPrenom()} </p>
                <p> <span class="fas fa-users"></span> Date de Debut : ${activete.getDate_debut()} </p>
                <p> <span class="fas fa-users"></span> Date de fin : ${activete.getDate_fin()} </p>
                <p> <span class="fas fa-users"></span> Date Debut inscrir : ${activete.getDate_de_participation()} </p>
                <p> <span class="fas fa-users"></span> Date Fin inscrir : ${activete.getDate_fin_participation()} </p>
                <button class="btn btn-primary p-2">Inscrir</button>
            </div>
        </c:forEach>
    </div>
</body>
</html>
