<%-- 
    Document   : Loop_processing_01
    Created on : 2018/06/01, 13:01:34
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
            long num = 1;      
            for(int count=1; count <= 20; count++){
                num *= 8;
            }
            out.print(num);
        %>
    </body>
</html>
