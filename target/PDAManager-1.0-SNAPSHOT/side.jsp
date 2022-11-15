<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="aside" class="side-bar col-sm-2 col-md-3 col-lg-2 d-flex flex-column gap-5">
    <div class="text-center">
        <p class="fw-bold h5 mt-2 name d-md-inline d-none">PDAManager</p>
        <div class="d-flex flex-column align-items-center mt-5">
            <img src='<c:url value="/Asets/Images/abdelaziz.jpg"></c:url>' />
            <span class="text-info name d-none d-md-inline  name">admin</span>
        </div>
    </div>

    <ul class="list-group">

        <li class="list-group-item">
            <a  class="btn mt-2 text-light d-flex" href="/PDAManager_war_exploded/listActivetes">
                <i class="fas fa-home pe-3"></i>
                <span class="fw-bold name d-none d-md-inline">Dashboard</span>
            </a>
        </li>


        <li class="list-group-item">
            <a class="btn mt-2 text-light d-flex" href="/PDAManager_war_exploded/listParticipant">
                <i class="fas fa-graduation-cap pe-3"></i>
                <span class="fw-bold text-white name d-none d-md-inline">Participants</span>
            </a>
        </li>

        <li class="list-group-item">
            <a class="btn mt-2 text-light d-flex" href="/PDAManager_war_exploded/profile">
                <i class="fas fa-graduation-cap pe-3"></i>
                <span class="fw-bold text-white name d-none d-md-inline">Profile</span>
            </a>
        </li>




        <li class="list-group-item">
            <a class="btn mt-5 text-light d-flex" href="/PDAManager_war_exploded/logout">
                <i class="fas fa-right-from-bracket pe-3"></i>
                <span class="fw-bold name d-none d-md-inline">Logout</span>
            </a>
        </li>

    </ul>
</aside>

<div class="px-1 active-cont">
    <header class="position-sticky bg-light top-0 w-100">
    </header>

