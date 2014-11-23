<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Log in</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
    .bs-example{
            width: 450px;
            padding: 20px;
            margin: 80px auto;
            background: #fff;
    }
</style>
</head>
<body>
        <div class="bs-example">
            <form method="POST" action="/signup">
                <div class="form-group">
                    <label>First name</label>
                    <input class="form-control" id="inputFirstName" placeholder="First name" name="firstName">
                </div>
                <div class="form-group">
                    <label>Last name</label>
                    <input class="form-control" id="inputLastName" placeholder="Last name" name="lastName">
                </div>
                <div class="form-group">
                    <label>Username</label>
                    <input class="form-control" id="inputUsername" placeholder="Username" name="username">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input class="form-control" id="inputEmail" placeholder="Email" name="email">
                </div>
                <div class="form-group">
                    <label>Contact</label>
                    <input class="form-control" id="inputContact" placeholder="Contact" name="contact">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                </div>
            </form>
        </div>
</body>
</html>