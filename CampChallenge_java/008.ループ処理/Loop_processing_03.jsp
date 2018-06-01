<%-- 
    Document   : Loop_processing_03
    Created on : 2018/06/01, 13:58:14
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
            int x = 0;
            for(int a = 0; a <= 100; a++){
                x += a;
            }
            out.print(x);
        %>
    </body>
</html>
