<%@page import="kagoyume.CartItem"
        import="kagoyume.UserDataDTO"
        import="java.util.ArrayList"
        import="kagoyume.KagoyumeHelper"%>
<%
    CartItem ci = (CartItem)session.getAttribute("CartItem");
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カート</title>
    </head>
    <body>
        ようこそ<a href="MyData"><%=udd.getName()%></a>さん!   <a href="Login?set=logout">ログアウト</a>
        <h1><%=udd.getName()%>のショッピングカート</h1>
        
        <%if(ci != null && ci.getItemSize() != 0){%>
        <table border="1">
            <tr><td>サムネイル画像</td><td>商品名</td><td>価格</td><td>数量</td><td></td></tr>
            <%for(int number = 0; number < ci.getItemSize(); number++){%>
                <tr>
                    <td><img src="<%=ci.getThumnail(number)%>" alt=""></td>
                    <td>
                        <a href="Item?itemID=<%=number%>&previous=cart">
                            <%=ci.getName(number)%>
                        </a>
                    </td>
                    <td><%=ci.getPrice(number) + "円"%></td>
                    <td><%=ci.getItemNumber(number) + "個"%></td>
                    <td>
                        <form action="Cart" method="get">
                            <input type="submit" value="削除">
                            <input type="hidden" name="delete" value="<%=number%>">
                        </form>
                    </td>  
                <tr>
            <%}%>
        </table>        
        <br>
        <form action="BuyConfirm" method="post">
            <input type="submit" value="購入する">
        </form> 
        <%} else {%>
        <p>お客様のショッピングカートに商品はありません。</p>
        <%}%>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>    