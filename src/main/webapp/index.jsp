<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Text Quest by Tsebal</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" type="text/css" href="static/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="static/custom.css">

</head>
<body>
<hr>
    <label for="inputNewName" id="labelName">Say your name:</label>
    <input type="text" id="inputNewName" name="name" required size="12" maxlength="12">
    <br>
        <c:set var="inputName" value="1"/>
<%--        <c:if test="${inputName != ''}">--%>
<%--            <h1 style="color:rgb(150,0,0)">NOUGHTS WIN!</h1>--%>
<%--            <button type="submit" onclick="createUserAccount()">Continue...</button>--%>
<%--        </c:if>--%>
    <br/>
<a href="start">Hello Servlet</a>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>