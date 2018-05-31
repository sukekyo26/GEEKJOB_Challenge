<%-- 
    Document   : Arithmetic_01
    Created on : 2018/05/31, 17:24:41
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
            int num1 = 45;
            final int num2 = 27;
            
            // 足し算
            out.print(num1 + num2 + "<br>");
            // 引き算
            out.print(num1 - num2 + "<br>");
            // かけ算
            out.print(num1 * num2 + "<br>");
            // 割り算
            out.print(num1 / num2 + "<br>");
            // 剰余算
            out.print(num1 % num2);
        %>
    </body>
</html>
