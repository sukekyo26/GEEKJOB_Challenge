<%-- 
    Document   : Array_02
    Created on : 2018/06/01, 11:41:56
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
        <%@ page import="java.util.ArrayList" %>
        <%
            String[] array = {"10", "100", "soeda", "hayashi", "-20", "118", "END"};
            array[2] = "33";
            for(int a = 0; a < array.length; a++){
                out.print(array[a] + "<br>");
            }
            out.print("<br>");
            ArrayList<String> array2 = new ArrayList<String>();
            array2.add("10");
            array2.add("100");
            array2.add("soeda");
            array2.add("hayashi");
            array2.add("-20");
            array2.add("118");
            array2.add("END");
            array2.remove("2");
            array2.set(2, "33");
            for(int b = 0; b < array2.size(); b++){
                out.print(array2.get(b) + "<br>");
            }
        %>
    </body>
</html>
