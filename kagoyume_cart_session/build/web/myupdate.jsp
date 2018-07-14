<%@page import="kagoyume.KagoyumeHelper"%>
<%
    HttpSession hs = request.getSession();
%>
<%-- 
    Document   : myupdate
    Created on : 2018/06/24, 16:03:56
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
        <h3>更新したいデータを記入してください。(未記入の欄は更新されません)</h3>
        <form action="MyUpdateResult" method="post">
            <p>
                ユーザー名:<br>
                <input type="text" name="user">
            </p>
            <p>
                パスワード:<br>
                <input type="text" name="password">
            </p>
            <p>
                メールアドレス:<br>
                <input type="email" name="mail">
            </p>
            <p>
                住所:<br>
                <input type="text" name="address">
            </p>
            <br>
            <input type="submit" value="更新">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
        </form>
        <br>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>
