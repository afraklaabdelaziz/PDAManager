<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"></jsp:include>
    <title>Title</title>
</head>
<body>
<jsp:include page="sideRes.jsp"></jsp:include>

<div class="d-flex flex-wrap gap-5">
    <c:forEach items="${participants}" var="participant">
        <div class="activite position-relative">
            <p> <span class="fas fa-users"></span> ${participant.getNom()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getPrenom()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getEmail()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getPhone()} </p>
            <p class="h5 nameClass mt-2"> ${participant.getDomaine()}</p>
            <p> <span class="fas fa-users"></span>  ${participant.getStructure()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getGenre()} </p>
        </div>
    </c:forEach>
</div>
</body>
</html>
