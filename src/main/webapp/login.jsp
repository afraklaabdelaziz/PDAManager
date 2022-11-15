<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="head.jsp"></jsp:include>

    <title>Register</title>
</head>
<body class="d-flex flex-column justify-content-center align-items-center">
<a href="/PDAManager_war_exploded/Choix">Register</a>
<form method="post"  class="flex justify-content-center p-5 bg-light">
    <div class="text-danger">
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

