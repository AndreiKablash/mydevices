<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page ="header.jsp"/>


<nav class="navbar sticky-top navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Household appliances</a>
</nav>

<div class="container-fluid">
    <div class="card-deck">

        <div class="card p-3">
            <img class="card-img" src="<%=request.getContextPath()%>/resources/images/hha.png" alt="Card image">
            <blockquote class="blockquote mb-0 card-body">
                <footer class="blockquote-footer">
                    <small class="text-muted">
                        <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:lightslategray">CHOOSE YOUR DEVICE</a></h5>
                    </small>
                </footer>
            </blockquote>
        </div>

        <div class="card bg-light mb-3" style="width: 15rem;">
            <img src="<%=request.getContextPath()%>/resources/images/cof.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:black" class="card-link">Coffee Machine</a></h5>
            </div>
        </div>

        <div class="card bg-light mb-3" style="width: 15rem;">
            <img src="<%=request.getContextPath()%>/resources/images/ket.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:black" class="card-link">Kettle</a></h5>
            </div>
        </div>

        <div class="card bg-light mb-3" style="width: 15rem;" >
            <img src="<c:url value="/resources/images/cook.png"/>" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:black" class="card-link">Cooker</a></h5>
            </div>

        </div>
    </div>


    <div class="card-deck">

        <div class="card bg-light mb-3" style="width: 15rem;">
            <img src="<c:url value="/resources/images/fridg.png"/>" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:black" class="card-link">Fridge</a></h5>
            </div>
        </div>

        <div class="card bg-light mb-3" style="width: 15rem;">
            <img src="<%=request.getContextPath()%>/resources/images/air.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title"><a href="#" style="color:black" class="card-link">Airconditioner</a></h5>
            </div>
        </div>

        <div class="card bg-light mb-3" style="width: 15rem;">
            <img src="<%=request.getContextPath()%>/resources/images/vac.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:black" class="card-link">Vacuum cleaner</a></h5>
            </div>
        </div>

        <div class="card bg-light mb-3" style="width: 15rem;">
            <img src="<%=request.getContextPath()%>/resources/images/blend.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:black" class="card-link">Blender</a></h5>
            </div>
        </div>

    </div>


    <div class="card-deck">

        <div class="card bg-light mb-3" style="width: 15rem;">
            <img src="<%=request.getContextPath()%>/resources/images/tv.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:black" class="card-link">TV</a></h5>
            </div>
        </div>

        <div class="card-deck">

            <div class="card bg-light mb-3" style="width: 15rem;">
                <img src="<%=request.getContextPath()%>/resources/images/ir.png" style="color:black" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:black" class="card-link">Iron</a></h5>
                </div>
            </div>

            <div class="card bg-light mb-3" style="width: 15rem;">
                <img src="<%=request.getContextPath()%>/resources/images/micr.jpg" style="color:black" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:black" class="card-link">Microwave</a></h5>
                </div>
            </div>

            <div class="card bg-light mb-3" style="width: 15rem;">
                <img src="<%=request.getContextPath()%>/resources/images/scale.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title"><a href="${pageContext.request.contextPath}/add-device" style="color:black">Weighing-Machine</a></h5>
                </div>
            </div>

        </div>
    </div>

</div>


<jsp:include page = "footer.jsp"/>