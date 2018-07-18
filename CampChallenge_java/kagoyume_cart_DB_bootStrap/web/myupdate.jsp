<%@page import="kagoyume.UserData"
        import="kagoyume.KagoyumeHelper"%>
<%
    HttpSession hs = request.getSession();
    UserData ud = (UserData)request.getAttribute("updateUser");
%>
<%-- 
    Document   : myupdate
    Created on : 2018/06/24, 16:03:56
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <title>ユーザーデータ更新</title>
    </head>
    <body>
        <header class="header">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="top.jsp" class="navbar-brand" style="font-size: 150%">かごゆめ</a>
                </div>
            </div>
        </nav>
        </header>
        <div class="container">
            <div class="panel panel-success">
                <div class="panel-body">
                    <h1 style="font-size: 200%">更新したいデータを記入してください(住所以外の未記入の欄は更新されません)</h1>
                    <form action="MyUpdateResult" method="post">
                        <div class="form-group">
                            <label for="user">ユーザー名：</label>
                            <input type="text" name="user" class="form-control" id="user">
                        </div>
                        <div class="form-group">
                            <label for="pass">パスワード：</label>
                            <input type="text" name="password" class="form-control" id="pass">
                        </div>
                        <div class="form-group">
                            <label for="mail">メールアドレス：</label>
                            <input type="email" name="mail" class="form-control" id="mail">
                        </div>
                        <div class="form-group">
                            <label for="address">住所(必須)：</label>
                            <input type="text" name="address-level1" placeholder="都道府県" value="<%if(ud != null){out.print(ud.getAddressLevel1());}%>" class="form-control" id="address">
                            <input type="text" name="address-level2" placeholder="市区町村" value="<%if(ud != null){out.print(ud.getAddressLevel2());}%>" class="form-control" id="address">
                            <input type="text" name="address-line1" placeholder="番地等" value="<%if(ud != null){out.print(ud.getAddressLine1());}%>" class="form-control" id="address">
                            <input type="text" name="address-line2" placeholder="アパート/マンション名等" value="<%if(ud != null){out.print(ud.getAddressLine2());}%>" class="form-control" id="address">
                        </div>
                        <div>
                        <%if(ud != null && !ud.getAddressCheck()){%><p style="color: red"><%out.print("＊住所の値が不正です＊");%></p><%}%>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">更新</button>
                            <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
                        </div>
                    </form>
                </div>
            </div>
            <%=KagoyumeHelper.getInstance().home()%>
        </div>
    </body>
    
</html>
