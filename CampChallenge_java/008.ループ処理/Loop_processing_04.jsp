<%-- 
    Document   : Loop_processing_04
    Created on : 2018/06/01, 14:40:23
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
            int a = 1000;
            while(a >= 100){
                a /= 2;
            }
            out.print(a);
        %>
    </body>
</html>
