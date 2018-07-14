
<%@page import="kagoyume.UserDataDTO"
        import="kagoyume.SearchBuyData"
        import="kagoyume.KagoyumeHelper"%>
<%
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
    SearchBuyData sbd = (SearchBuyData)request.getAttribute("BuyData");
%>
<%-- 
    Document   : myhistory
    Created on : 2018/06/24, 16:03:42
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入履歴</title>
    </head>
    <body>
        <h1><%=udd.getName()%>さんの購入履歴</h1>
        <%if(sbd.getItemSize() != 0){%>
            <table border="1">
            <%for(int count = 0; count < sbd.getItemSize(); count++){%>
            <tr><td>商品画像</td><td>商品名</td><td>価格</td><td>個数</td><td>購入日時</td><td>発送方法</td></tr>
            <tr><td><img src="<%=sbd.getThumnail(count)%>"></td><td><%=sbd.getItemName(count)%></td><td><%=sbd.getItemPrice(count)%>円</td><td><%=sbd.getItemNumber(count)%></td><td><%=sbd.getBuyDate(count)%></td><td><%if(sbd.getType(count) == 1){out.print("ヤマト運輸");} else if(sbd.getType(count) == 2){out.print("佐川急便");} else {out.print("ゆうパック");}%></td></tr>
            <%}%>
            </table>
        <%}else{%>
        <font size="5"><strong>お客様の購入履歴はありません</strong></font>
        <%}%>
        <br>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>