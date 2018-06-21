<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) session.getAttribute("udb");
    UserDataBeans udbr = (UserDataBeans) request.getAttribute("udbr");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<% if(udb != null) out.print(udb.getName()); %>">
        <br><br>

        生年月日:
        <select name="year">
            <% if(udb != null && udb.getYear() != 0) { %> <option value="<% out.print(udb.getYear()); %>"> <% out.print(udb.getYear()); %></option><% } %>
            <option value="0">----</option>
            <% 
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <% if(udb != null && udb.getMonth() != 0){ %> <option value="<% out.print(udb.getMonth()); %>"> <% out.print(udb.getMonth()); %></option><% } %>
            <option value="0">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <% if(udb != null && udb.getDay() != 0){ %> <option value="<% out.print(udb.getDay()); %>"><% out.print(udb.getDay()); %></option><% } %>
            <option value="0">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <% if(udb == null){ %> checked <% } else if(udb.getType() == 1){ %> checked <% }  %>>エンジニア<br>
        <input type="radio" name="type" value="2" <% if(udb != null && udb.getType() == 2){ %> checked <% }  %>>営業<br>
        <input type="radio" name="type" value="3" <% if(udb != null && udb.getType() == 3){ %> checked <% } %>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<% if(udb != null) out.print(udb.getTell());%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><% if(udb != null) out.print(udb.getComment());%></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
