<%@page import="kagoyume.UserDataDTO"
        import="java.text.SimpleDateFormat"
        import="kagoyume.KagoyumeHelper"%>
<%
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
%>
<%-- 
    Document   : mydata
    Created on : 2018/06/24, 16:00:12
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Data</title>
    </head>
    <body>
        <a href="Login?set=logout">ログアウト</a>
        <h2><%=udd.getName()%>さんのユーザー情報</h2>
        <table border="1">
            <tr><td>ユーザー名</td><td><%=udd.getName()%></td></tr>
            <tr><td>メールアドレス</td><td><%=udd.getMail()%></td></tr>
            <tr><td>住所</td><td><%=udd.getAddress()%></td></tr>            
            <tr><td>登録日時</td><td><%=sdf.format(udd.getNewDate())%></td></tr>
            <tr><td>総購入金額</td><td><%=udd.getTotal()%>円</td></tr>
            <tr><td>購入履歴</td><td><a href="MyHistory">別ページ</a></td></tr>
        </table>
        <br>
        <form action="MyUpdate" method="post">
            <input type="submit" value="ユーザーデータを更新">
        </form>
        <form action="MyDelete" method="post">
            <input type="submit" value="ユーザーデータを削除">
        </form>
        <br>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>
