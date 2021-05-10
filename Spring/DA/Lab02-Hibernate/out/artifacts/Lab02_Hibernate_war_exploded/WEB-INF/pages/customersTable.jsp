<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
            <h1>=== Users Page ===</h1>
            <br>

            <table>
                <c:forEach var="customer" items="${customer}">

                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.salary}</td>
                    </tr>

                </c:forEach>
            </table>

            <h1>===========================================</h1>
            <a href="${pageContext.request.contextPath}/register" type="button">Add New User</a>
        </center>

    </div>
    
</body>
</html>