<%@page import="kagoyume.UserData"
        import="kagoyume.KagoyumeHelper"%>
<%
    UserData ud = (UserData)session.getAttribute("newUser");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録</title>
    </head>
    <body>
        <form action="RegistrationConfirm" method="post">
            <h1>新規会員登録</h1>
            <p>
                ユーザー名：<input type="text" name="user" value="<%if(ud != null){out.print(ud.getName());}%>">
            </p>
            <p>
                パスワード：<input type="text" name="password" value="<%if(ud != null){out.print(ud.getPassword());}%>">
            </p>
            <p>
                メールアドレス：<input type="email" name="mail" value="<%if(ud != null){out.print(ud.getMail());}%>">
            </p>
            <p>
                住所：<br>
                <input type="text" name="address-level1" placeholder="都道府県" value="<%if(ud != null){out.print(ud.getAddressLevel1());}%>"><br>
                <input type="text" name="address-level2" placeholder="市区町村" value="<%if(ud != null){out.print(ud.getAddressLevel2());}%>"><br>
                <input type="text" name="address-line1" placeholder="番地等" value="<%if(ud != null){out.print(ud.getAddressLine1());}%>"><br>
                <input type="text" name="address-line2" placeholder="アパート/マンション名等" value="<%if(ud != null){out.print(ud.getAddressLine2());}%>"><br>
                <%if(ud != null && !ud.getAddressCheck()){%><font color="red"><%out.print("＊住所の値が不正です＊");%></font><%}%>
                
            </p>
            <%if(ud != null && !ud.getMarkCheck()){%><font color="red"><%out.print("＊未記入の項目を入力してください＊");%></font><%}%>
            <br>
            <input type="submit" value="登録">
        </form>
        <br>
        <%=KagoyumeHelper.getInstance().home()%>
    </body>
</html>
