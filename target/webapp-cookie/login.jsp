<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Iniciar sesion</title>
</head>
<body>
    <form action="/webapp-cookie/login" method="post">
        <div>
            <label for="username">Usuario:</label>
            <div>
                <input type="text" id="username" name="username">
            </div>
        </div>
        <div>
            <label for="password">Contraseña:</label>
            <div>
                <input type="password" id="password" name="password">
            </div>
        </div>
        <div>
            <input type="submit" value="Login">
        </div>

    </form>

</body>
</html>