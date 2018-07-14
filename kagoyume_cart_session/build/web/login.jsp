<%@page import="kagoyume.LoginBeans"
        import="kagoyume.KagoyumeHelper"%>
<%
    LoginBeans lb = (LoginBeans)request.getAttribute("loginInfo");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="post">
            <h1>ログイン</h1>
            <p>ユーザー名：</p>
            <input type="text" name="userName">
            <p>パスワード：</p>
            <input type="password" name="password">
            <br><br>
            <input type="submit" value="ログイン">
            <input type="hidden" name="previousPage" value="<%=lb.getPreviousPage()%>">
            <input type="hidden" name="set" value="login">
            <a href="Registration">新規会員登録</a><br>
            <%if(lb.getLoginFail()){%>
            <font color="red">＊ログインに失敗しました＊</font>
            <%}%>
        </form>
        <br>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>
