<%@ page import="com.playground.model.UserBean" %>
<%@ page import="java.util.List" %>
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

        <%!
            public String   print(String str){
                return str;
            }
        %>


        <%
            List<UserBean> userList  = (List<UserBean>) request.getAttribute("result");
            if(userList != null){
             //Not null, we got an actual result
             //Start displaying It
                System.out.println("got rsult lol xd"+ userList);
                for(UserBean user : userList){
        %>
                <tr>
                    <th>
                        <%= user.getFirstName()%>
                    </th>
                    <th>
                        <%= user.getLastName()%>
                    </th>
                    <th>
                        <%= user.getUserName()%>
                    </th>
                    <th>
                        <%= user.getPassword()%>
                    </th>
                </tr>
        <%
                }
            }
        %>

        </table>

        </center>
</body>
</html>
