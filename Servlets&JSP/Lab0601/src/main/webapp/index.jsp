<%@ page import="com.playground.model.UserBean" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My JSP Search</title>
</head>
<body>


    <center>
    <h1 style='margin:50px auto;'>SEARCH Form</h1>
    <h4 style='margin:20px auto;'>Enter First Name To start searching</h4>

   <FORM action='processing'  method= get>

       <div style='margin:50px auto;'>
		<label for='key' style='font-size:20px;margin-right:10px;'>Search : </label>
        <INPUT TYPE=TEXT NAME='key'><BR>
       <BR> <INPUT style='background-color:cyan;color:white;font-size20px;' TYPE=SUBMIT VALUE=Submit><BR>
        </div>
        </FORM>

    <table style='width:75%'> <caption>Users</caption>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>UserName</th>
            <th>Password</th>
        </tr>
        
        <c:if test ="${!(empty requestScope.result)}">

            <c:forEach items="${requestScope.result}" var="user">
                 <tr>
                <th>
                    <c:out value="${user.getFirstName()}"/>
                </th>
                <th>
                    <c:out value="${user.getLastName()}"/>
                </th>
                <th>
                    <c:out value="${user.getUserName()}"/>
                </th>
       
                <th>
                    <c:out value="${user.getPassword()}"/>
                </th>
                            </tr>

            </c:forEach>
        </c:if>
        

        </table>

        </center>
</body>
</html>
