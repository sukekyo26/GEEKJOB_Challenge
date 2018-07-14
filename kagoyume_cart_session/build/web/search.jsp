
<%@page import="kagoyume.SearchResult"
        import="kagoyume.UserDataDTO"
        import="kagoyume.KagoyumeHelper"%>
<%
    SearchResult sr = (SearchResult)session.getAttribute("SearchResult");
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
%>
<%-- 
    Document   : search
    Created on : 2018/06/28, 14:04:41
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果</title>
    </head>
    <body>
        <%if(udd != null){%>
        ようこそ<a href="MyData"><%=udd.getName()%></a>さん!   <a href="Login?set=logout">ログアウト</a>   <a href="Cart">買い物かご</a>
        <%}else{%>
        <a href="Login?previous=top"><font size="4"><b>ログイン</b></font></a>
        <%}%>
        <%if(sr.getHitCount() != 0){%>
        <p><font size="5">検索キーワード「"<%=sr.getKeyword()%>"」(カテゴリ:<%=sr.getCategoryName()%>/ソート順:<%=sr.getSortName()%><%if(!sr.getHighPrice().equals("")){%>/最高金額設定:<%=sr.getHighPrice()%>円<%}%><%if(!sr.getLowPrice().equals("")){%>/最低金額設定:<%=sr.getLowPrice()%>円<%}%>)の検索結果 <%out.print("--" + sr.getHitCount() + "件表示--");%></font></p><br>
        
        <table border="1">
            <tr><td>サムネイル画像</td><td>商品名</td><td>値段</td></tr>
            <%for(int number = 0; number < sr.getHitCount(); number++){%>
            <tr><td><img src="<%=sr.getThumnail(number)%>"></td><td><a href="Item?id=<%=number%>"><%=sr.getName(number)%></a></td><td><%=sr.getPrice(number) + "円"%></td><tr>
            <%}%>
        </table>
        <%} else {%>
        <p><font size="5">検索キーワード「"<%=sr.getKeyword()%>"」に該当する商品はありませんでした(カテゴリ:<%=sr.getCategoryName()%>/ソート順:<%=sr.getSortName()%><%if(!sr.getHighPrice().equals("")){%>/最高金額設定:<%=sr.getHighPrice()%>円<%}%><%if(!sr.getLowPrice().equals("")){%>/最低金額設定:<%=sr.getLowPrice()%>円<%}%>) <%out.print("--" + sr.getHitCount() + "件表示--");%></font></p>
        <%}%>
        <br>
        <%=kagoyume.KagoyumeHelper.getInstance().home()%>
    </body>
</html>