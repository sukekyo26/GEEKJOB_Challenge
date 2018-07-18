<%@page import="kagoyume.KagoyumeHelper"
        import="kagoyume.UserDataDTO"%>
<%
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <title>追加</title>
    </head>
    <body>
        <header class="header">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">メニュー</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="top.jsp" class="navbar-brand" style="font-size: 150%">かごゆめ</a>
                </div>                
                <div class="collapse navbar-collapse">
                    <%if(udd != null){%>
                    <ul class="nav navbar-nav navbar-right">
                        <li><p class="navbar-text">ようこそ<a href="MyData"><%=udd.getName()%></a>さん!</p></li> 
                        <li><a href="Cart"><i class="fas fa-shopping-cart"></i> 買い物かご</a></li>
                        <li><a href="Login?set=logout"><strong><i class="fas fa-sign-out-alt"></i> ログアウト</strong></a></li>
                    </ul>
                    <%}else{%>
                    <ul class="nav navbar-nav navbar-right">    
                        <li><a href="Login?previous=add"><strong><i class="fas fa-sign-in-alt"></i> ログイン</strong></a></li>
                    </ul>
                    <%}%>
                </div>
            </div>
        </nav>
        </header>
        <h1 style="font-size: 150%">カートに追加しました！！</h1>
        <br>
        <form action="Cart" method="post">
            <div class="form-group">
                <button type="submit" class="btn btn-default">カートに移動</button>
                <input type="hidden" name="check" value="user">
            </div>
        </form>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>
