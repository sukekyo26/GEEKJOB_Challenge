<%@page import="kagoyume.UserData"%>
<%
    HttpSession hs = request.getSession();
    UserData ud = (UserData)session.getAttribute("newUser");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>登録確認</h1>
        <p>ユーザー名：<%=ud.getName()%></p>
        <p>パスワード：<%=ud.getPassword()%></p>
        <p>メールアドレス：<%=ud.getMail()%></p>
        <p>住所：<%=ud.getAddress()%></p>
        <br>
        <h4>上記の内容で登録します。よろしいですか？</h2>
        <form action="RegistrationComplete" method="post">
            <input type="submit" value="はい" style="width:100px">
            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
        </form>
        <br>
        <form action="Registration" method="post">
            <input type="submit" value="いいえ" style="width:100px">
        </form>
    </body>
</html>
