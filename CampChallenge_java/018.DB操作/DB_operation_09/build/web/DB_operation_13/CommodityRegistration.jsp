<%-- 
    Document   : CommodityRegistration
    Created on : 2018/06/16, 19:59:38
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "DB_operation_13.User"%>
<%@page import = "javax.servlet.RequestDispatcher"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            User user = (User)session.getAttribute("user");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CommodityRegistration</title>
    </head>
    <body>
        <%
            if(user == null) {
                RequestDispatcher rsLogin = request.getRequestDispatcher("/DB_operation_13/Login.jsp");
                    rsLogin.forward(request, response);
            }  
        %>
        <form action="/018_DB_operation/DB_operation_13" method="post">
            <p>商品登録</p>
            <p>
                商品名:<br>
                <input type="text" name="name" pattern="^[^\x20-\x7E]*" required>
            </p> 
            <p>
                個数:<br>
                <input type="number" name="number" required>
            </p>
            <p>
                単価:<br>
                <input type="number" name="price" required>
            </p>
            <p>
                ジャンル:<br>
                <select name="genre">
                    <option value="" selected>選択してください</option>
                    <option value="食品・飲料">食品・飲料</option>
                    <option value="日用品">日用品</option>
                    <option value="本">本</option>
                    <option value="おもちゃ">おもちゃ</option>
                    <option value="電化製品">電化製品</option>
                    <option value="美容品">美容品</option>
                </select>
            </p>
            <p><input type="submit" value="登録" name="submit">
                <a href="http://localhost:8080/018_DB_operation/DB_operation_13/CommodityList.jsp">商品一覧</a>
                <a href="http://localhost:8080/018_DB_operation/DB_operation_13/Logout.jsp">ログアウト</a>
            </p>
        </form>    
    </body>
</html>
