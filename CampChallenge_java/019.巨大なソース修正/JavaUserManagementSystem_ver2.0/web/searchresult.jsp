<%@page import="java.text.SimpleDateFormat"
        import="java.util.Date"
        import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="java.util.ArrayList" 
        import="javax.servlet.http.HttpSession" %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)request.getAttribute("searchResultData");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
            <%if(udd.size() == 0){%><p><%out.print("一致するデータはありませんでした");%></p><%}else{%>
            <table border=1>
                <%for(int i = 0; i < udd.size(); i++){ %>       
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
           
            <tr>
                <td><a href="ResultDetail?id=<%= (Integer)udd.get(i).getUserID()%>"><%=(String)udd.get(i).getName()%></a></td>
                <td><%= sdf.format(udd.get(i).getBirthday())%></td>
                <td><% if((Integer)udd.get(i).getType() == 1){out.print("営業");} else if ((Integer)udd.get(i).getType() == 2){out.print("エンジニア");} else {out.print("その他");}%></td>
                <td><%= (Date)udd.get(i).getNewDate()%></td>
            </tr>
                    <%}%>
            </table>
            
            
            <%}%> 
        
    </body>
    <%=jh.home()%>
</html>
