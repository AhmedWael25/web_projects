

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="doubler" uri="/WEB-INF/doubler.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custom Tag   </title>
    </head>
    <body>
                
    <center>
                <h1 style="margin:30px auto;">Your custom TAG</h1>
        <doubler:DoublerHandler number="20"/>
         
        
    </center>

        
    </body>
</html>
