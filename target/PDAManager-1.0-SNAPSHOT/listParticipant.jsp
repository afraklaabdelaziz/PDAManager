<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"></jsp:include>
    <title>Title</title>
</head>
<body>
<jsp:include page="sideRes.jsp"></jsp:include>
<div class="position-sticky top-0">
    <form method="post">
        <button value="Homme" type="submit" name="genre">Homme</button>
        <button value="Femme" type="submit" name="genre">Femme</button>
    </form>
</div>
<div class="d-flex flex-wrap gap-5">
    <c:if test="${ not empty sessionScope.genre}" ><c:forEach items="${participantGenre}" var="participant">

        <div class="activite position-relative">
            <p> <span class="fas fa-users"></span> ${participant.getNom()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getPrenom()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getEmail()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getPhone()} </p>
            <p class="h5  mt-2"> ${participant.getDomaine()}</p>
            <p> <span class="fas fa-users"></span>  ${participant.getStructure()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getGenre()} </p>
        </div>
    </c:forEach>
    </c:if>

    <c:if test="${empty sessionScope.genre}" ><c:forEach items="${participantGenre}" var="participant">

        <div class="activite position-relative">
            <p> <span class="fas fa-users"></span> ${participant.getNom()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getPrenom()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getEmail()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getPhone()} </p>
            <p class="h5  mt-2"> ${participant.getDomaine()}</p>
            <p> <span class="fas fa-users"></span>  ${participant.getStructure()} </p>
            <p> <span class="fas fa-users"></span> ${participant.getGenre()} </p>
        </div>
    </c:forEach>
    </c:if>
</div>
</body>
</html>
