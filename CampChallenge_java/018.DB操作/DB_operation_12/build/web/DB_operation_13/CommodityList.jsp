<%-- 
    Document   : CommodityList
    Created on : 2018/06/16, 20:00:13
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "DB_operation_13.User"%>
<%@page import= "javax.servlet.RequestDispatcher"%>
<%@page import= "javax.servlet.http.HttpSession"%>
<%@page import= "java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <%
            User user = (User)session.getAttribute("user");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(user == null) {
                RequestDispatcher rsLogin = request.getRequestDispatcher("/DB_operation_13/Login.jsp");
                    rsLogin.forward(request, response);
            }
            Connection co = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                co = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?CharacterEncording=UTF-8&serverTimezone=JST", "root", "");
                ps = co.prepareStatement("SELECT * FROM commodities WHERE commodityID >= 1 ORDER BY genre ASC");
                rs = ps.executeQuery();
        %>
        <table border="1">
            <tr><td>商品名</td><td>個数</td><td>単価</td><td>ジャンル</td><td>ID</td><td></td></tr>    
            <% while(rs.next()){ %>
            <tr><td><% out.print(" " + rs.getString(2) + " "); %></td>
                <td><% out.print(" " + rs.getString(3) + "個 ");%></td>
                <td><% out.print(" " + rs.getString(4) + "円 ");%></td>
                <td><% out.print(" " + rs.getString(5) + "<br>");%></td>
                <td><% out.print(" " + rs.getString(1) + " ");%></td>
                <td>
                    <form action="/018_DB_operation/DB_operation_13" method="post">    
                        <button type="form" name="delete" value="<%out.print(rs.getString(1));%>">削除</button>
                    </form>
                </td></tr>
            <% } %>
        </table>
            
        <%       
                co.close();
                ps.close();
                rs.close();
            } catch(SQLException ex) {
                out.print("接続時にエラーが発生しました：" + ex.toString());
            } catch(Exception e) {
                out.print("接続時にエラーが発生しました：" + e.toString());
            } finally {
                if(co != null){
                    try{
                        co.close();
                    } catch(Exception e_co){
                        out.print(e_co.getMessage());
                    }    
                }
                if(ps != null){
                    try{
                        ps.close();
                    } catch(Exception e_ps){
                        out.print(e_ps.getMessage());
                    }    
                }
                if(rs != null){
                    try{
                        rs.close();
                    } catch(Exception e_rs){
                        out.print(e_rs.getMessage());
                    }    
                }   
            }    
        %>
        <a href="http://localhost:8080/018_DB_operation/DB_operation_13/CommodityRegistration.jsp">商品登録画面へ</a>
    </body>
</html>
