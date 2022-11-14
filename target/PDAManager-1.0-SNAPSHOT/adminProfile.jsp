<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"></jsp:include>
    <title>Title</title>
</head>
<body>
<div>
<jsp:include page="side.jsp"></jsp:include>
<div class="d-flex flex-column p-4 mt-4 bg-light">
        <p><span class="fw-bold">Nom :</span> ${user.getNom()} </p>
        <p><span class="fw-bold">Prenom :</span> ${user.getPrenom()} </p>
        <p><span class="fw-bold">Email :</span> ${user.getEmail()}</p>
        <p><span class="fw-bold">Telephone :</span> ${user.getPhone()} </p>
        <p><span class="fw-bold">Adresse :</span> ${user.getAdresse().getAdresse()}</p>
        <p><span class="fw-bold">Ville :</span> ${user.getAdresse().getVille().getNom()} </p>
        <div class="d-flex justify-content-between">
            <p><span class="fw-bold">Pays :</span> ${user.getAdresse().getVille().getPays().getNom()}</p>
            <div class="btns btn btn-primary p-2 " data-bs-toggle="modal" href="#updateProfile">Update</div>
        </div>
</div>
</div>

<!-- form add  -->
<div class="modal fade" id="updateProfile">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <form method="post" class="form-group w-100">
                    <p class="h4">Ajouter activite</p>
                    <div>
                        <label for="nom" class="label-control">Nom</label>
                        <input type="text" class="form-control" name="nomUp" id="nom" value="${user.getNom()}">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="prenom" class="label-control">Prenom</label>
                        <input type="text" class="form-control" name="prenomUp" id="prenom" value="${user.getPrenom()}">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="email" class="label-control">Email</label>
                        <input class="form-control" type="email" name="emailUp" id="email" value="${user.getEmail()}">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="phone" class="label-control">Phone</label>
                        <input type="text" class="form-control" name="phoneUp" id="phone" value="${user.getPhone()}">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="adresse" class="label-control">Adresse</label>
                        <input type="text" class="form-control" name="adresseUp" id="adresse" value="${user.getAdresse().getAdresse()}">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="ville" class="label-control">Ville</label>
                        <input type="text" class="form-control" name="villeUp" id="ville" value="${user.getAdresse().getVille().getNom()}">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="pays" class="label-control">Pays</label>
                        <input type="text" class="form-control" name="paysUp" id="pays" value="${user.getAdresse().getVille().getPays().getNom()}">
                        <div class="error"></div>
                    </div>
                    <div>
                        <label for="password" class="label-control">Pays</label>
                        <input type="password" class="form-control" name="passwordUp" id="password" value="${user.getPassword()}">
                        <div class="error"></div>
                    </div>
                    <input type="submit" class="form-control btn btns mt-4" value="Update">
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<!-- end form -->

</body>
</html>
