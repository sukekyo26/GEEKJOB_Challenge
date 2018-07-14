<%
    HttpSession hs = request.getSession();
%>
<%-- 
    Document   : mydelete
    Created on : 2018/06/24, 16:04:23
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザー削除確認</title>
    </head>
    <body>
        
        <h3>本当にユーザーデータを削除しますか？</h3>
        <br>
        <form action="MyDeleteResult" method="post">
            <input type="submit" value="はい">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
        </form>
        <form action="top.jsp" method="post">
            <input type="submit" value="いいえ(トップページへ戻る)">
        </form>
    </body>
</html>
