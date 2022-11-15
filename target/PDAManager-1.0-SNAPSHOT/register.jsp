<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="com.example.pdamanager.Entities.Type" %>
<%@ page import="com.example.pdamanager.Entities.Genre" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="head.jsp"></jsp:include>
    <title>Register</title>
</head>
<body class="d-flex justify-content-center align-items-center">
<form method="post" class="p-3 bg-light col-11 col-md-6">
    <div class="mb-3 d-flex gap-3">
        <div class="col-6">
            <label class="form-label">Nom</label>
            <input type="text" class="form-control" name="nom" >
        </div>
        <div class="col-6">
            <label class="form-label">Prenom</label>
            <input type="text" class="form-control" name="prenom" >
        </div>
    </div>
    <div class="d-flex mb-3 gap-3">
        <div class="col-6">
            <label  class="form-label">Email address</label>
            <input type="email" class="form-control" name="email" >
        </div>
        <div class="col-6">
            <label class="form-label"> N Telephone</label>
            <input type="text" class="form-control" name="phone" >
        </div>
    </div>

    <% HttpSession session1 = request.getSession();if (session1.getAttribute("choose").equals("1")){%>
    <div class="mb-3">
        <label class="form-label">Domaine</label>
        <input type="text" class="form-control" name="domaine" >
    </div>
    <div class="mb-3">
        <label >Saisir votre Type</label>
        <select name="typeResponsable" class="form-select" >
            <%
                Type [] types = (Type[]) request.getAttribute("typeRes");
                for (Type type : types){%>
            <option value="<%= type %>"><%= type %></option>
            <% }%>
        </select>
    </div>
    <%}else if (session1.getAttribute("choose").equals("2")){%>
    <div class="mb-3 d-flex gap-3">
        <div class="col-6">
            <label class="form-label">Domain</label>
            <input type="text" class="form-control" name="domaine" >
        </div>
        <div class="col-6">
            <label class="form-label">Structure</label>
            <input type="text" class="form-control" name="structure" >
        </div>
    </div>
    <div class="mb-3">
        <label >Choisir votre Genre</label>
        <select name="genre" class="form-select" >
            <%
                Genre[] genres = (Genre[]) request.getAttribute("genre");
                for (Genre genre : genres){%>
            <option value="<%= genre %>"><%= genre %></option>
            <% }%>
        </select>
    </div>
    <%}%>
    <div class="mb-3 d-flex gap-3">
        <div class="col-6">
            <label class="form-label">Pays</label>
            <input type="text" class="form-control" name="pays" >
        </div>
       <div class="col-6">
           <label class="form-label">Ville</label>
           <input type="text" class="form-control" name="ville" >
       </div>
    </div>
    <div class="mb-3 d-flex gap-3">
        <div class="col-6">
            <label class="form-label">Adresse</label>
            <input type="text" class="form-control" name="adresse" >
        </div>
        <div class="col-6">
            <label class="form-label">Code Postal</label>
            <input type="text" class="form-control" name="code" >
        </div>
    </div>
    <div class="mb-3 col-12">
        <label  class="form-label">Password</label>
        <input type="password" class="form-control" name="password">
    </div>
    <button type="submit" class="btn btn-primary">Regiser</button>
</form>
</body>
</html>
