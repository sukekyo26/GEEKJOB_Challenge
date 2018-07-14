<%@page import="kagoyume.UserDataDTO"
        import="kagoyume.KagoyumeHelper"%>
<%
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
%>
<%-- 
    Document   : buycomplete
    Created on : 2018/06/24, 16:02:33
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
        ようこそ<a href="MyData"><%=udd.getName()%></a>さん!   <a href="Login?set=logout">ログアウト</a>
        <h2>購入が完了しました。</h2>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>
