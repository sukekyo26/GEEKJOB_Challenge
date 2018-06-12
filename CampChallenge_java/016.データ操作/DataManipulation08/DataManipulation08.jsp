<%-- 
    Document   : DataManipulation08
    Created on : 2018/06/12, 10:11:43
    Author     : sumi3
--%>

<%@page import = "DataManipulation08.Profile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <% 
            Profile ps = (Profile)session.getAttribute("profile");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>プロフィールを記入してください</h1>
        <form action="/016_Data_Manipulation/DataManipulation08" method="post">
            <p>名前:<input type="text" name="name"value="<% if(ps.getName() != null) out.print(ps.getName()); %>"></p>
            <p>性別:
                <input type="radio" name="gender" value="男" <% if(ps.getGender().equals("男")) out.print("checked"); %>>男
                <input type="radio" name="gender" value="女" <% if(ps.getGender().equals("女")) out.print("checked"); %>>女
            </p>
            <p>
                趣味を入力してください:<br>
                <textarea cols="30" rows="6" name="interest"><% if(ps.getInterest() != null) out.print(ps.getInterest()); %></textarea>
            </p>
            <p><input type="submit" value="送信"></p>
        </form>
    </body>
</html>
