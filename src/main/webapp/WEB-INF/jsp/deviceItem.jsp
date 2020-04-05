<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>


<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">${device.deviceType.description} ${device.deviceName}</a>
</nav>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Sensor</th>
        <th scope="col">Type</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${sensors}">
        <tr>
            <th scope="row">${item.id}</th>
            <td><a href="${pageContext.request.contextPath}/devices/device/${device.id}/sensor/${item.id}" class="badge badge-light">${item.sensorName}</a></td>
            <td>${item.sensorType.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>