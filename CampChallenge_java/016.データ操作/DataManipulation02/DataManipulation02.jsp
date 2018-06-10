<%-- 
    Document   : DataManipulation02
    Created on : 2018/06/10, 15:35:23
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
            request.setCharacterEncoding("UTF-8");
            out.print(request.getParameter("name"));
            out.print(request.getParameter("gender"));
            out.print(request.getParameter("interest"));
        %>
    </body>
</html>
