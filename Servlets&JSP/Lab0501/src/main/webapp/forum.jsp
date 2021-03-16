
<html>
<head>
    <title>Form</title>
</head>
<body>


<center>
    <FORM action='main.jsp' method= POST>

        <div style='margin:50px auto;'>
            <label for='firstName' style='font-size:20px;margin-right:10px;'>FirstName : </label>
            <INPUT TYPE=TEXT NAME='firstName'><BR>
        </div>

        <div style='margin:50px auto;'>
		<label for='lastName' style='font-size:20px;margin-right:10px;'>Lastname : </label>
        <INPUT TYPE=TEXT NAME='lastName'><BR>
        </div>


        <div style='margin:50px auto;'>
		<label for='userName' style='font-size:20px;margin-right:10px;'>Username : </label>
        <INPUT TYPE=TEXT NAME='userName'><BR>
       </div>


        <div style='margin:50px auto;'>
		<label for='password' style='font-size:20px;margin-right:10px;'>Password : </label>
        <INPUT TYPE=PASSWORD	NAME='password'><BR>
        </div>

        <BR>
        <INPUT style='background-color:cyan;color:white;font-size:20px;' TYPE=SUBMIT VALUE=Submit><BR>

        </FORM>
    </center>



</body>
</html>
