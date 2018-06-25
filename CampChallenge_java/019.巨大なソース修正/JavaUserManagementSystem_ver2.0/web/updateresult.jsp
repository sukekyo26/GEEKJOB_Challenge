<%@page import="java.text.SimpleDateFormat"
        import="jums.JumsHelper" 
        import="jums.UserDataDTO"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO newUdd = (UserDataDTO)request.getAttribute("updateData");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");//java.util.DateをStringに変換
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        名前:<%=newUdd.getName()%><br>
        生年月日:<%=sdf.format(newUdd.getBirthday())%><br>
        種別:<%if(newUdd.getType() == 1){out.print("営業");} else if (newUdd.getType() == 2){out.print("エンジニア");} else {out.print("その他");}%><br>
        電話番号:<%=newUdd.getTell()%><br>
        自己紹介:<%=newUdd.getComment()%><br>
        以上の内容で登録しました。<br>
        <form action="ResultDetail" method="POST">
            <input type="submit" name="back" value="詳細情報に戻る">    
        </form>
    </body>
    <%=jh.home()%>
    </body>
</html>
