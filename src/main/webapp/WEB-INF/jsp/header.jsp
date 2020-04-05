<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>My devices!</title>
</head>
<body>

<ul class="nav navbar-dark bg-dark">
    <a class="navbar-brand" href="#">
        <img src="<%=request.getContextPath()%>/resources/images/smart.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
        Home Device Data
    </a>
    <li class="nav-item">
        <a class="nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
    </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/devices">My Devices</a>
        </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/add-device">Add Device</a>
    </li>
    <sec:authorize access="!isAuthenticated()">
        <li class="nav-item">
            <a class="nav-link " href="${pageContext.request.contextPath}/registration" >Registration</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " href="${pageContext.request.contextPath}/login" >Login</a>
        </li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <li class="nav-item">
            <a class="nav-link " href="${pageContext.request.contextPath}/logout" >Logout</a>
        </li>
    </sec:authorize>
</ul>
