<%@page import="java.text.SimpleDateFormat"
        import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="javax.servlet.http.HttpSession" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)session.getAttribute("resultDetail");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        名前:<%= udd.getName()%><br>
        生年月日:<%= sdf.format(udd.getBirthday())%><br>
        種別:<% if(udd.getType() == 1){out.print("営業");} else if (udd.getType() == 2){out.print("エンジニア");} else {out.print("その他");}%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
        <form action="Update" method="POST">
        <input type="submit" name="update" value="変更"style="width:100px">
        </form>
        <form action="Delete" method="POST">
        <input type="submit" name="delete" value="削除"style="width:100px">
        </form>
        <br>
        <form action="SearchResult" method="POST">
        <input type="submit" name="back" value="検索結果に戻る">    
        </form>
    </body>
</html>
