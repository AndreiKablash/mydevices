<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="alert alert-success" role="alert">
    A ${deviceType} ${deviceName} with sensor ${sensorName} has been added!
</div>

<a class="btn btn-primary" href="${pageContext.request.contextPath}/home" role="button">Back</a>

<jsp:include page="footer.jsp"/>