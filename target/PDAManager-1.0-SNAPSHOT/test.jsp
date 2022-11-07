

<%@ page import="java.lang.reflect.Array" %>
<%@ page import="com.example.pdamanager.Entities.Type" %>
<%@ page import="com.example.pdamanager.Entities.Genre" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 01/11/2022
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="Asets/css/style.css">
<script src="https://kit.fontawesome.com/a523390b1d.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <title>Document</title>
</head>
<body>
    <aside id="aside" class="side-bar cole-md-12 d-flex flex-column gap-5">
        <div class="text-center">
        <p class="title fw-bold h5 mt-2">Gestion d'école</p>
        <div class="d-flex flex-column align-items-center mt-5">
        <img class="rounded-circle w-50" src="abdelaziz.jpg" alt="admin">
       <span class="text-info">admin</span>
       </div>
        </div>

        <ul class="list-group">

        <li class="list-group-item">
        <a data-bs-toggle="list" class="btn text-light" href="#">
            <i class="fas fa-home pe-3"></i>
           <span class="fw-bold">Home</span>
        </a>
       </li>


       <li class="list-group-item">
       <a data-bs-toggle="list" class="btn mt-2 text-light" href="#">
        <i class="fas fa-graduation-cap pe-3"></i>
       <span class="fw-bold text-white">Etudiant</span>
       </a>
       </li>


       <li class="list-group-item">
       <a data-bs-toggle="list" class="btn mt-2 text-light" href="#">
        <i class="fas fa-person-chalkboard pe-3"></i>
        <span class="fw-bold text-white">Profeseurs</span>
        </a>
       </li>


        <li class="list-group-item">
        <a data-bs-toggle="list" class="btn mt-2 text-light" href="#">
        <i class="fas fa-person-chalkboard pe-3"></i>
      <span class="fw-bold">Parents</span>
       </a>
       </li>


       <li class="list-group-item">
        <a data-bs-toggle="list" class="btn mt-2 text-light" href="#">
        <i class="fas fa-user-class pe-3"></i>
      <span class="fw-bold">Clases</span>
    </a>
    </li>


    <li class="list-group-item">
    <a data-bs-toggle="list" class="btn mt-5 text-light" href="#">
        <i class="fas fa-right-from-bracket pe-3"></i>
     <span class="fw-bold">Logout</span>
    </a>
</li>

</ul>
    </aside>


    <div id="my-container" class="px-1">
        <header class="position-sticky top-0 w-100">
            <i class="btn fas fa-hand-point-right" id="menu"></i>
        </header>
        <div class="d-flex justify-content-between mb-4">
            <p class="h4">List Classes</p>
            <div class="btn btns" data-bs-toggle="modal" href="#add">ADD NEW CLASS</div>
        </div>


        <!-- form add  -->
        <div class="modal fade" id="add">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <div class="modal-header">
        <form action="" method="post" class="form-group w-100">
        <p class="h4">Add new class</p>
    <div>
        <label for="name" class="label-control">Name Clases</label>
        <input type="text" class="form-control" name="name" id="name">
        <div class="error"></div>
    </div>
    <div>
        <label for="number" class="label-control">Number students </label>
        <input class="form-control" type="number" name="number" id="number">
        <div class="error"></div>
    </div>
    <div>
        <label for="Teacher" class="label-control">Teacher</label>
        <input type="text" class="form-control" name="Teacher" id="Teacher">
        <div class="error"></div>
    </div>
        <input type="submit" class="form-control btn btns mt-4" name="save">
        </form>
    </div>
    </div>
    </div>
    </div>
        <!-- end form -->


       <div class="d-flex justify-content-center flex-wrap gap-5">
        <div class="clase position-relative">
            <i class="fas fa-ellipsis-h btn position-absolute top-0 end-0"></i>
            <div class="d-none action">
                <a href=""><i class="fas fa-edit"></i> <span>Update</span></a>
                <a href=""><i class="fas fa-trash"></i> <span>Update</span></a>
            </div>
            <img class="rounded-circle w-50 mx-5" src="abdelaziz.jpg" alt="clase">
            <p class="h5 text-center nameClass mt-2">Name Class</p>
            <p> <span class="fas fa-users"></span> Number Students</p>
            <p> <span class="fas fa-person-chalkboard"></span> Teacher</p>
        </div>


        <div class="clase position-relative">
            <i class="fas fa-ellipsis-h btn position-absolute top-0 end-0"></i>
            <div class="d-none action">
                <a href=""><i class="fas fa-edit"></i> <span>Update</span></a>
                <a href=""><i class="fas fa-trash"></i> <span>Update</span></a>
            </div>
            <img class="rounded-circle w-50 mx-5" src="abdelaziz.jpg" alt="clase">
            <p class="h5 text-center nameClass mt-2">Name Class</p>
            <p> <span class="fas fa-users"></span> Number Students</p>
            <p> <span class="fas fa-person-chalkboard"></span> Teacher</p>
        </div>


        <div class="clase position-relative">
            <i class="fas fa-ellipsis-h btn position-absolute top-0 end-0"></i>
            <div class="d-none action">
                <a href=""><i class="fas fa-edit"></i> <span>Update</span></a>
                <a href=""><i class="fas fa-trash"></i> <span>Update</span></a>
            </div>
            <img class="rounded-circle w-50 mx-5" src="abdelaziz.jpg" alt="clase">
            <p class="h5 text-center nameClass mt-2">Name Class</p>
            <p> <span class="fas fa-users"></span> Number Students</p>
            <p> <span class="fas fa-person-chalkboard"></span> Teacher</p>
        </div>


        <div class="clase position-relative">
            <i class="fas fa-ellipsis-h btn position-absolute top-0 end-0"></i>
            <div class="d-none action">
                <a href=""><i class="fas fa-edit"></i> <span>Update</span></a>
                <a href=""><i class="fas fa-trash"></i> <span>Update</span></a>
            </div>
            <img class="rounded-circle w-50 mx-5" src="abdelaziz.jpg" alt="clase">
            <p class="h5 text-center nameClass mt-2">Name Class</p>
            <p> <span class="fas fa-users"></span> Number Students</p>
            <p> <span class="fas fa-person-chalkboard"></span> Teacher</p>
        </div>


        <div class="clase position-relative">
            <i class="fas fa-ellipsis-h btn position-absolute top-0 end-0"></i>
            <div class="d-none action">
                <a href=""><i class="fas fa-edit"></i> <span>Update</span></a>
                <a href=""><i class="fas fa-trash"></i> <span>Update</span></a>
            </div>
            <img class="rounded-circle w-50 mx-5" src="abdelaziz.jpg" alt="clase">
            <p class="h5 text-center nameClass mt-2">Name Class</p>
            <p> <span class="fas fa-users"></span> Number Students</p>
            <p> <span class="fas fa-person-chalkboard"></span> Teacher</p>
        </div>


        <div class="clase position-relative">
            <i class="fas fa-ellipsis-h btn position-absolute top-0 end-0"></i>
            <div class="d-none action">
                <a href=""><i class="fas fa-edit"></i> <span>Update</span></a>
                <a href=""><i class="fas fa-trash"></i> <span>Update</span></a>
            </div>
            <img class="rounded-circle w-50 mx-5" src="abdelaziz.jpg" alt="clase">
            <p class="h5 text-center nameClass mt-2">Name Class</p>
            <p> <span class="fas fa-users"></span> Number Students</p>
            <p> <span class="fas fa-person-chalkboard"></span> Teacher</p>
        </div>


        <div class="clase position-relative">
            <i class="fas fa-ellipsis-h btn position-absolute top-0 end-0"></i>
            <div class="d-none action">
                <a href=""><i class="fas fa-edit"></i> <span>Update</span></a>
                <a href=""><i class="fas fa-trash"></i> <span>Update</span></a>
            </div>
            <img class="rounded-circle w-50 mx-5" src="abdelaziz.jpg" alt="clase">
            <p class="h5 text-center nameClass mt-2">Name Class</p>
            <p> <span class="fas fa-users"></span> Number Students</p>
            <p> <span class="fas fa-person-chalkboard"></span> Teacher</p>
        </div>


        <div class="clase position-relative">
            <i class="fas fa-ellipsis-h btn position-absolute top-0 end-0"></i>
            <div class="d-none action">
                <a href=""><i class="fas fa-edit"></i> <span>Update</span></a>
                <a href=""><i class="fas fa-trash"></i> <span>Update</span></a>
            </div>
            <img class="rounded-circle w-50 mx-5" src="abdelaziz.jpg" alt="clase">
            <p class="h5 text-center nameClass mt-2">Name Class</p>
            <p> <span class="fas fa-users"></span> Number Students</p>
            <p> <span class="fas fa-person-chalkboard"></span> Teacher</p>
        </div>
       </div>
    </div>


<%--   <script>--%>
<%--       // variable--%>
<%--       var myList = document.getElementById("myList");--%>
<%--       let lists = document.querySelectorAll('.list');--%>
<%--       let menu = document.getElementById('menu');--%>
<%--       let aside = document.getElementById('aside');--%>
<%--      let container = document.getElementById("my-container");--%>
<%--      let actions = document.querySelectorAll('.fa-ellipsis-h');--%>

<%--       // select les actions sur class--%>
<%--      for (const action of actions) {--%>
<%--          action.addEventListener("click",function(){--%>
<%--            const selects = action.parentElement;--%>
<%--            const select = selects.querySelector('.action');--%>
<%--            select.classList.toggle('d-none')--%>
<%--            action.classList.toggle("fa-ellipsis-h")--%>
<%--            action.classList.toggle("fa-times")--%>
<%--          });--%>
<%--      }--%>

<%--      // side bar--%>
<%--       menu.addEventListener("click",function(){--%>
<%--           aside.classList.toggle('d-none');--%>
<%--           container.classList.toggle('active-cont');--%>
<%--           menu.classList.toggle("fa-hand-point-left");--%>
<%--           menu.classList.toggle("fa-hand-point-right");--%>
<%--       })--%>
<%--   </script>--%>
</body>
</html>