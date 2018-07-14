<%@page import="kagoyume.CartItem"
        import="kagoyume.UserDataDTO"%>
<%
    HttpSession hs = request.getSession();
    CartItem ci = (CartItem)session.getAttribute("CartItem");
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="BuyComplete" method="post">
            <h1>購入確認</h1>
            <table border="1">
                <tr><td>商品名</td><td>金額</td><td>個数</td></tr>
                <%for(int a = 0; a < ci.getItemSize(); a++){%>
                    <%if(ci.getUserID(a) == udd.getUserID()){%>
                    <tr><td><%=ci.getName(a)%></td><td><%=ci.getPrice(a) + "円"%></td><td><%=ci.getItemNumber(a) + "個"%></td></tr>
                    <%}%>
                <%}%>
            </table>
            <font color="red">合計金額<font size="6"><%=ci.getSumPrice(udd)%></font>円</font>
            <br>
            <p>発送方法</p>
            <input type="radio" name="type" value="1" checked>ヤマト運輸
            <input type="radio" name="type" value="2">佐川急便
            <input type="radio" name="type" value="3">ゆうパック
            <br>
            <br>
            <input type="submit" value="以上の内容で購入する">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
        </form>
        <form action="Cart" method="post">
            <input type="submit" value="カートに戻る">
        </form>    
    </body>
</html>
