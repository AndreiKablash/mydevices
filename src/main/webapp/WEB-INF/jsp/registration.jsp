<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<h1>Register new user</h1>

<form method="POST" action="${pageContext.request.contextPath}/registration">
    <div class="form-group">
        <label for="login">Login Name</label>
        <input type="text" name="login" class="form-control" id="login" placeholder="Enter login">
        <small class="form-text text-muted">Please enter your login</small>
    </div>
    <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter first name">
        <small class="form-text text-muted">Please enter your first name</small>
    </div>
    <div class="form-group">
        <label for="lastName">Last Name</label>
        <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter last name">
        <small class="form-text text-muted">Please enter your last name</small>
    </div>
    <div class="form-group">
        <label for="email">Your email</label>
        <input type="email" name="email" class="form-control" id="email" placeholder="Enter your email">
        <small class="form-text text-muted">Please enter your email</small>
    </div>
    <div class="form-group">
        <label for="password">Your password</label>
        <input type="password" name="password" class="form-control" id="password" placeholder="Enter your password">
        <small class="form-text text-muted">Please enter your password</small>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>