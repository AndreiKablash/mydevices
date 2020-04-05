<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="header.jsp"/>

<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand">Your Devices!</a>
    <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/search">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search-str">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Device</th>
        <th scope="col">Model</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${devices}">
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