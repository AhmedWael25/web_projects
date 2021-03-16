<%@ page import="jakarta.servlet.RequestDispatcher" %>

<html>
<head>
    <title>main</title>
</head>
<body>

<jsp:useBean id="myUser" class="com.playground.model.UserBean" scope="request"/>
<jsp:setProperty name="myUser" property="*"/>



<%
    System.out.println(myUser.getFirstName());
    System.out.println(myUser.getLastName());
    System.out.println(myUser.getUserName());
    System.out.println(myUser.getPassword());
//jsp:forw
    RequestDispatcher rd = request.getRequestDispatcher("second.jsp");
    rd.forward(request,response);

%>



</body>
</html>
