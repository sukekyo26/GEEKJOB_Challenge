<%-- 
    Document   : Associative_array_01
    Created on : 2018/06/01, 12:04:32
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
        <%@ page import = "java.util.HashMap" %>
        <%
            HashMap<String, String> list = new HashMap<String, String>();
            list.put("1", "AAA");
            list.put("hello", "world");
            list.put("soeda","33");
            list.put("20","20");
            out.print(list.get("soeda"));
        %>
    </body>
</html>
