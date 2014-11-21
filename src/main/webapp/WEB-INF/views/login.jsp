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
            width: 500px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
    }
</style>
</head>
<body>
        <div class="bs-example">
             <form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
                <div class="form-group">
                    <label for="inputUsername">Username</label>
                    <input type="username" class="form-control" name="username" id="inputUsername" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" class="form-control" name="password" id="inputPassword" placeholder="Password">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Log in</button>
                </div>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                <c:if test="${not empty error}">
                    <div class="form-group">
                        <label>
                            ${error}
                        </label>
                    </div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="form-group">
                        <label>
                            ${msg}
                        </label>
                    </div>
                </c:if>

            </form>
        </div>
</body>
</html>                                     