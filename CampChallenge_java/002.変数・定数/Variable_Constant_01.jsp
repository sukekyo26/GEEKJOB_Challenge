<%-- 
    Document   : Variable_Constant_01
    Created on : 2018/05/31, 16:48:45
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
        <h1>
            <%
                String hello = "私の名前は小泉丞巨です";
                out.print(hello);
            %>
        </h1>
    </body>
</html>
