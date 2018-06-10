<%-- 
    Document   : DataManipulation04
    Created on : 2018/06/10, 17:52:56
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
        <%
            //文字コード
            request.setCharacterEncoding("UTF-8");
            //商品種別番号
            int type = Integer.valueOf(request.getParameter("type"));
            //商品種別の日本語情報の表示
            if (type == 1){
                out.print("雑貨<br>");
            } else if (type == 2){
                out.print("生鮮食品<br>");
            } else {
                out.print("その他<br>");
            }
            
            //購入商品の数量
            int num = Integer.valueOf(request.getParameter("count"));
            //購入商品の総額
            int amount = Integer.valueOf(request.getParameter("total"));
            //商品の単価
            int unitPrice = amount / num;
            //単価の表示
            out.print("商品の単価は" + unitPrice + "円です<br>");
            //ポイントの表示
            out.print("今回獲得したポイントは");
            if(amount < 3000){
                out.print("0ポイントです");
            } else if (amount >= 3000 && amount < 5000){
                int point = amount / 25;
                out.print(point + "ポイントです");
            } else {
                int point = amount / 20;
                out.print(point + "ポイントです");
            }
        %>
    </body>
</html>
