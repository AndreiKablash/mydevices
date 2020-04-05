<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">${sensor.sensorType.description} ${sensor.sensorName}</a>
</nav>

<table class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Value</th>
        <th scope="col">Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${sensor.sensorData}">
        <tr>
            <th scope="row">${item.id}</th>
            <td>${item.value}</td>
            <td>${item.date}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a class="btn btn-primary" href="${pageContext.request.contextPath}/chart" role="button">Go to chart</a>



<jsp:include page="footer.jsp"/>