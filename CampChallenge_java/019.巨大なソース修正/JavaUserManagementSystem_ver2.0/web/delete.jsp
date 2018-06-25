<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)session.getAttribute("resultDetail");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？<br>
    名前:<%= udd.getName()%><br>
    生年月日:<%= sdf.format(udd.getBirthday())%><br>
    種別:<%if(udd.getType() == 1){out.print("営業");} else if (udd.getType() == 2){out.print("エンジニア");} else {out.print("その他");}%><br>
    電話番号:<%= udd.getTell()%><br>
    自己紹介:<%= udd.getComment()%><br>
    登録日時:<%= udd.getNewDate()%><br>
    
    <form action="DeleteResult" method="POST">
      <input type="submit" name="YES" value="はい"style="width:100px">
    </form><br>
    <form action="ResultDetail" method="POST">
      <input type="submit" name="NO" value="いいえ(詳細情報に戻る)">
    </form>
    </body>
</html>
