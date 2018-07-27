<%-- 
    Document   : Logout
    Created on : 2018/06/17, 13:03:35
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "DB_operation_13.User"%>
<%@page import = "javax.servlet.RequestDispatcher"%>
<%@page import= "javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            User user = (User)session.getAttribute("user");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(user == null) {
                RequestDispatcher rsLogin = request.getRequestDispatcher("/DB_operation_13/Login.jsp");
                rsLogin.forward(request, response);
            }
            session.invalidate();
            RequestDispatcher rsLogin = request.getRequestDispatcher("/DB_operation_13/Login.jsp");
            rsLogin.forward(request, response);
        %>
    </body>
</html>
