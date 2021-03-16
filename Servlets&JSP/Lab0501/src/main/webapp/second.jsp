<%@ page import="jakarta.servlet.RequestDispatcher" %>

<html>
<head>
    <title>second</title>
</head>
<body>

<jsp:useBean id="UserBean" class="com.playground.model.UserBean" scope="request"/>
<jsp:setProperty name="UserBean" property="*"/>


<center>
    First Name: <jsp:getProperty name="UserBean" property="firstName" />
    <br>
    Last Name: <jsp:getProperty name="UserBean" property="lastName" />
    <br>
    User Name: <jsp:getProperty name="UserBean" property="userName" />
    <br>
    Password :<jsp:getProperty name="UserBean" property="password" />
</center>



</body>
</html>
