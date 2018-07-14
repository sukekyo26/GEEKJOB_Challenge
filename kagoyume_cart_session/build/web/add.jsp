<%@page import="kagoyume.KagoyumeHelper"
        import="kagoyume.UserDataDTO"%>
<%
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>追加</title>
    </head>
    <body>
        <%if(udd != null){%>
        ようこそ<a href="MyData"><%=udd.getName()%></a>さん!   <a href="Login?set=logout">ログアウト</a>   <a href="Cart">買い物かご</a>
        <%}else{%>
        <a href="Login?previous=top"><font size="4"><b>ログイン</b></font></a>
        <%}%>
        <p>カートに追加しました！！</p>
        <form action="Cart" method="post">
            <input type="submit" name="cart" value="カートに移動">
            <input type="hidden" name="check" value="user">
        </form>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>
