<%@ page import="java.lang.reflect.Array" %>
<%@ page import="com.example.pdamanager.Entities.Type" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 01/11/2022
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
          crossorigin="anonymous"
  />
  <title>Register</title>
</head>
<body>
<form method="post" name="FormRegister"   class="flex justify-content-center ms-5 me-5 w-75">
  <div class="mb-3">
    <label class="form-label">Nom</label>
    <input type="text" class="form-control" name="nom" >
  </div>
  <div class="mb-3">
    <label class="form-label">Prenom</label>
    <input type="text" class="form-control" name="prenom" >
  </div>
  <div class="mb-3">
    <label  class="form-label">Email address</label>
    <input type="email" class="form-control" name="email" >
  </div>
  <div class="mb-3">
    <label class="form-label"> N Telephone</label>
    <input type="text" class="form-control" name="phone" >
  </div>
  <div class="mb-3">
    <label class="form-label">Domaine</label>
    <input type="text" class="form-control" name="domaine" >
  </div>
  <div class="mb-3">
    <label >Saisir votre Type</label>
    <select name="typeResponsable" >
      <%
        Type [] types = (Type[]) request.getAttribute("typeRes");
        for (Type type : types){%>
      <option value="<%= type %>"><%= type %></option>
      <% }%>
    </select>
  </div>
  <div class="mb-3">
    <label class="form-label">Pays</label>
    <input type="text" class="form-control" name="pays" >
  </div>
  <div class="mb-3">
    <label class="form-label">Ville</label>
    <input type="text" class="form-control" name="ville" >
  </div>
  <div class="mb-3">
    <label class="form-label">Adresse</label>
    <input type="text" class="form-control" name="adresse" >
  </div>
  <div class="mb-3">
    <label class="form-label">Code Postal</label>
    <input type="text" class="form-control" name="code" >
  </div>
  <div class="mb-3">

    <label  class="form-label">Password</label>
    <input type="password" class="form-control" name="password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>
