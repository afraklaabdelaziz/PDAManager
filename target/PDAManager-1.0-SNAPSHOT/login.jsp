<%--
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
    <div class="alert alert-danger" role="alert">
        ${sessionScope.error}
    </div>
    <div class="mb-3">
        <label  class="form-label">Email address</label>
        <input type="email" class="form-control" name="email">
    </div>

    <div class="mb-3">
        <label  class="form-label">Password</label>
        <input type="password" class="form-control" name="password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

