<%-- 
    Document   : Loop_processing_02
    Created on : 2018/06/01, 13:45:14
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           String a = "A";
            for(int x = 1; x < 30; x++){
                a += "A";
            }
            out.print(a);
        %>
    </body>
</html>
