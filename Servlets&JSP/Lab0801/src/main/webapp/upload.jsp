

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custom Tag   </title>
    </head>
    <body>
                
    <center>
                
        
        <center>
            
            <h1 style="margin: 50px auto;">Upload Your File !</h1>

            
            <form method="post" action="uploadFile" enctype="multipart/form-data" >

                    File:
                    <input style="margin: 40px auto;" type="file" name="fileName" />
                    
                    <br>
                    
                    
                    <input style="margin: 40px auto;" type="text" value="/tmp" name="destination" hidden/>
                    
                    <BR> 
                    
                    <INPUT style='background-color:cyan;color:white;font-size:20px;' TYPE=SUBMIT VALUE=Upload !><BR>
                </form>
                
        </center>

    </center>

        
    </body>
</html>
