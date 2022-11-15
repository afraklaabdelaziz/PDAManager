<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 11/15/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="head.jsp"></jsp:include>
    <title>Title</title>
</head>
<body>
<div>
    <jsp:include page="side.jsp"></jsp:include>

        <div class="d-flex flex-wrap gap-5">
            <c:forEach items="${participantList}" var="participant">
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
</div>

</body>
</html>
