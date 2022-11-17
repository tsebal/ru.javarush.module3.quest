<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Text Quest by Tsebal</title>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:useBean id="gamesService"
                 class="ru.javarush.module3.quest.service.GameService" scope="session"/>
    <%  request.getSession(true);
        String userName = gamesService.getUserNameBySessionId(session.getId());
        session.setAttribute("userName", userName);
    %>

    <link rel="stylesheet" type="text/css" href="static/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="static/custom.css">

</head>
<body>
    <h1>Welcome, '<% session.getAttribute("userName"); %>' stranger!</h1>
    <p>Listen to me soon! You came here from a quantum portal. It was meant to be.</p>
    <hr>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>