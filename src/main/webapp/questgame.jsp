<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Text Quest by Tsebal</title>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
        String userName = session.getAttribute("userName").toString();
        String userIP = request.getRemoteAddr();
        String userScore = session.getAttribute("userScore").toString();
        String question = session.getAttribute("question").toString();
    %>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="static/custom.css">

</head>
<body>

<div class="block">
    <h3><%= question %>
    </h3>
</div>
<hr>
<c:if test="${!sessionScope.end}">
    <form action="questgame" method="post">
        <div class="form-check">
            <c:forEach var="answer" items="${sessionScope.answers}">
                <input class="form-check-input" type="radio" name="id" id="answerRadioDefault"
                       value="${answer.id}">
                <label class="form-check-label" for="answerRadioDefault">
                        ${answer.text}
                </label><br>
            </c:forEach>
            <br>
            <button type="submit">Continue...</button>
        </div>
    </form>
</c:if>
<hr>
<%--<h4><%= answer0 %></h4>--%>
<%--<h4><%= answer1 %></h4>--%>
<hr>
<p>Your name: <%= userName %><br>
    Score: <%= userScore %><br>
    Your IP-address: <%= userIP %>
</p>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>