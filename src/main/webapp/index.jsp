<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>App</title>
</head>

<body>
    <div class="content">
        <h1>Login</h1>
        <form method="POST" action="login">
            <input type="text" name="email" placeholder="email">
            <input type="password" name="password" placeholder="password">
            <input type="submit" value="Login">
        </form>
    </div>

    <h3 class="error">${error.message}</h3>
    <h3 class="error">${message}</h3>

</body>
</html>
