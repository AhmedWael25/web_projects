<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="includes/headTags.jsp"%>
    <title>ContactPage</title>
</head>

<c:set value="${pageContext.request.contextPath}" var="contextPath"/>

<body>
<%@include file="includes/navbarElement.jsp"%>

    <div>
        <center>

            <c:if test="${param.error != null}" >
                <h5 style="color: red">Invalid Username/Password</h5>
            </c:if>

            <h1>=== Login Page ===</h1>
            <br>

            <form:form action="${contextPath}/submitlogin" method="post">
                <h2>Username: </h2>
                <input type="text" name="username"/>
                <br>
                <h2>password: </h2>
                <input type="text" name="password"/>
                <br>
                <br>
                <h2>Remember me:</h2>
                <br>
                <br>
                <input type="checkbox" name="remember-me">
                <input type="submit" value="Submit">

            </form:form>

        </center>

    </div>
    <%@include file="includes/tailTags.jsp"%>
</body>
</html>