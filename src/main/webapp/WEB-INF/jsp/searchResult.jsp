<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="header.jsp"/>

<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand">My Devices!</a>
</nav>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Device</th>
        <th scope="col">Model</th>
        <th scope="col">Number of sensors</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${result}">
        <tr>
            <th scope="row">${item.id}</th>
            <td>${item.deviceType.description}</td>
            <td><a href="${pageContext.request.contextPath}/devices/device/${item.id}" class="badge badge-light">${item.deviceName}</a></td>
            <td><a href="${pageContext.request.contextPath}/devices/device/${item.id}" class="badge badge-light">${fn:length(item.sensors)}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>