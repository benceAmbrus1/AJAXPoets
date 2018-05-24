<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="js/utils.js"></script>
    <script type="text/javascript" src="js/poems.js"></script>
    <title>App</title>
</head>

<body>
    <h1>AJAX Poets</h1>
    <div id="profile" class="info content">
        <h3>Profile</h3>
        <p>User name: ${user.name}</p>
        <p>User email: ${user.email}</p>
        <form action="login" method="GET">
            <input type="submit" class="button" value="Logout">
        </form>
    </div>

    <div id="works" class="hidden content">
        <h3>Poems</h3>
        <div id="works-content">
        </div>
    </div>

    <h3>${error}</h3>
</body>
</html>
