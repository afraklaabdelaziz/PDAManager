<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="head.jsp"></jsp:include>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy-MM-dd" />
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
                <p <c:if test="${activete.getEtatActivité() == 'Active'}" >class="text-success" </c:if> <c:if test="${activete.getEtatActivité() == 'Desactive'}" >class="text-danger"</c:if> > <span class="fas fa-users"></span> Etat Activité : ${activete.getEtatActivité()}</p>
                <p> <span class="fas fa-users"></span> Responsable : ${activete.getResponsable().getNom()} ${activete.getResponsable().getPrenom()} </p>
                <p> <span class="fas fa-users"></span> Date de Debut : ${activete.getDate_debut()} </p>
                <p> <span class="fas fa-users"></span> Date de fin : ${activete.getDate_fin()} </p>
                <p> <span class="fas fa-users"></span> Date Debut inscrir : ${activete.getDate_de_participation()} </p>
                <p> <span class="fas fa-users"></span> Date Fin inscrir : ${activete.getDate_fin_participation()} </p>
                <button <c:if test="${activete.getDate_fin_participation() <= year}" > </c:if> data-bs-toggle="modal" href="#envoyeeDemande" class="btn btn-primary p-2">Inscrir</button>
            </div>


    <!-- form add  -->
    <div class="modal fade" id="envoyeeDemande">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <form method="post" class="form-group w-100">
                        <p class="h4">Demande de participation</p>
                        <div>
                            <label for="title" class="label-control">Message</label>
                            <input type="text" class="form-control" name="message" id="title">
                            <div class="error"></div>
                        </div>
                        <input type="hidden" name="emailResponsable" value="${activete.getResponsable().getEmail()}">
                        <input type="submit" class="form-control btn btns mt-4" value="Demander">
                    </form>
                </div>
            </div>
        </div>
    </div>
    </c:forEach>
    </div>
</body>
</html>
