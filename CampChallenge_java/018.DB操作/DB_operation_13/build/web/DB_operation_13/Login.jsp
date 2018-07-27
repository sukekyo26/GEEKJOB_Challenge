<%-- 
    Document   : Login
    Created on : 2018/06/16, 18:20:54
    Author     : sumi3
    在庫管理システムのスタート画面。
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "DB_operation_13.Error" %>
<!DOCTYPE html>
<html>
    <head>
        <%
            Error data = (Error)request.getAttribute("login");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
        <form action="/018_DB_operation/DB_operation_13" method="post">
            <p>
                ユーザーID:<br>
                <input type="text" name="user" maxlength="30" pattern="^([a-zA-Z0-9]{4,})$" title="半角英数字4文字以上" required>
            </p>
            <p>
                パスワード:<br>
                <input type="password" name="password" maxlength="30" required>
            </p>
            <p><input type="submit" value="ログイン"></p>
        </form>
        <%
            if(data != null){
        %>
        <p><font color="red">*ログインできませんでした*</font></p>
        <%}%>
    </body>
</html>
