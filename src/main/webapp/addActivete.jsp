
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
            crossorigin="anonymous"
    />
    <title>Title</title>
</head>
<body>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addActivete">add</button>
<p class="h4">List Produits</p>
<div class="d-flex ms-5 ps-5 flex-wrap gap-5">
    <div class="produitList position-relative col-8 col-md-4 col-lg-3">
        <i class="fas fa-ellipsis-h position-absolute top-0 end-0 m-2 ellipsis"></i>
        <div class="d-none action">
            <a href=""><i class="fas fa-edit"></i> <span>Edite</span></a>
            <a href=""><i class="fas fa-trash"></i> <span>Supprimer</span></a>
        </div>
        <img class="imgProduit" src="" alt="sdkjgjhgdjh">
        <p class="h5 m-2">Type activité : </p>
        <p class="h5 m-2">Date : </p>
    </div>

</div>

<div class="modal fade" id="addActivete" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"></span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" name="FormRegister"   class="flex justify-content-center ms-5 me-5 w-75">
                    <div class="mb-3">
                        <label class="form-label">date debut</label>
                        <input type="date" class="form-control" name="dateDebut" >
                    </div>
                    <div class="mb-3">
                        <label class="form-label">date fin </label>
                        <input type="date" class="form-control" name="dateFin" >
                    </div>
                    <div class="mb-3">
                        <label  class="form-label">date debut inscription</label>
                        <input type="date" class="form-control" name="dateDI" >
                    </div>
                    <div class="mb-3">
                        <label class="form-label"> date fin inscription</label>
                        <input type="date" class="form-control" name="dateFI" >
                    </div>

                    <div class="mb-3">

                        <label  class="form-label">desciption</label>
                        <input type="text" class="form-control" name="desc">
                    </div>
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
