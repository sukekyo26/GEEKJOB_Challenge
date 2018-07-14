
<%@page import="kagoyume.SelectItem"
        import="kagoyume.UserDataDTO"
        import="kagoyume.KagoyumeHelper"%>
<%
    SelectItem si = (SelectItem)session.getAttribute("selectItem");
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品詳細</title>
    </head>
    <body>
        <%if(udd != null){%>
        ようこそ<a href="MyData"><%=udd.getName()%></a>さん!   <a href="Login?set=logout">ログアウト</a>   <a href="Cart">買い物かご</a>
        <%}else{%>
        <a href="Login?previous=top"><font size="4"><b>ログイン</b></font></a>
        <%}%>
        <form action="Add" method="get">
            <h1>詳細情報</h1>
            <p><img src="<%=si.getLargeThumnail()%>"></p>
            <h2>商品名</h2>
            <p><%=si.getName()%></p>
            <h2>商品説明</h2>
            <p><%=si.getDescription()%></p>
            <h3>評価点</h3>
            <p><%=si.getRate()%>点</p>
            <br>
            <h3><font color="red">価格 <font size="6"><%=si.getPrice()%></font>円　(税込)</font>
        　　数量：
            <select name="number">
                <%for(int num =1; num < 11; num++){%>
                <option value="<%=num%>"><%=num%></option>
                <%}%>
            </select>
            </h3>
            <br>
            <input type="submit" value="カートに追加">
        </form>
        <br>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>
