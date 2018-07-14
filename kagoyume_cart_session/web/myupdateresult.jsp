<%@page import="kagoyume.UserDataDTO"
        import="kagoyume.TopError"
        import="kagoyume.KagoyumeHelper"%>
<%
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
    TopError te = (TopError)request.getAttribute("markCheck");
%>
<%-- 
    Document   : myupdateresult
    Created on : 2018/06/24, 16:04:11
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>情報更新</title>
    </head>
    <body>
        ようこそ<a href="MyData"><%=udd.getName()%></a>さん!   <a href="Login?set=logout">ログアウト</a>
        <%if(te.getMarkCheck()){%>
        <h1>ユーザー情報更新完了</h1>
        <p>ユーザー名：<%=udd.getName()%></p>
        <p>パスワード：<%=udd.getPassword()%></p>
        <p>メールアドレス：<%=udd.getMail()%></p>
        <p>住所：<%=udd.getAddress()%></p>
        <font size="3">以上の内容で更新しました。</font>
        <br>
        <%}else{%>
        <p><font size="5"><strong>入力が無かった為データは更新されませんでした</strong></font></p>
        <%}%>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>
