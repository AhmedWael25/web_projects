<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ContactPage</title>
</head>
<body>


    <div>
        <center>
            <h1>=== Login Page ===</h1>
            <br>

            <form name="loginForm" action="/submitlogin" method="post">

                <h4>Username</h4>
                <input type="text" name="username">
                <br>

                <h4>password</h4>
                <input type="text" name="password">



            <%--==================================--%>
            <%--Normal HTML form needs this hidden input to have the CSRF token with it--%>
            <%--usign spring's form:form tag will insert this automaticaly --%>
            <%-- THis neds to be in any foorm we use, thymeleaf or jsp  --%>
            <%-- bec. spring enables csrf protection, if not put = exception  --%>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </form>


        </center>

    </div>
    
</body>
</html>