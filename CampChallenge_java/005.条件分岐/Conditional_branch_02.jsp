<%-- 
    Document   : Conditional_branch_02
    Created on : 2018/05/31, 21:49:55
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
            int num = 2;
            switch (num){
                case 1:
                   out.print("one");
                   break;
                case 2:
                    out.print("two");
                    break;
                default:
                    out.print("想定外");
                    break;
            }
        %>
    </body>
</html>
