<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Upload Multiple File Request Page</title>
</head>
<body>

<form method="POST" action="upload" enctype="multipart/form-data">
    <table style="border: 0px">
        <tr>
            <td>
                Username :
            </td>
            <td>
                <input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td>
                Password :
            </td>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td>
                File to upload:
            </td>
            <td>
                <input type="file" name="file"><br/>
            </td>
            <input type="hidden"
                   name="${_csrf.parameterName}" value="${_csrf.token}" />
        </tr>
    </table>

    <input type="submit" value="upload">
</form>

</body>
</html>