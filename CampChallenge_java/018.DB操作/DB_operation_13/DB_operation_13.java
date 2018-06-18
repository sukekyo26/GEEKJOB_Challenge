/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_operation_13;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.sql.*;
import DB_operation_13.User;
import DB_operation_13.Error;

/**
 *
 * @author sumi3
 */
public class DB_operation_13 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DB_operation_13</title>");            
            out.println("</head>");
            out.println("<body>");
            
            request.setCharacterEncoding("UTF-8");
            Connection co = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                co = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?CharacterEncording=UTF-8&serverTimezone=JST", "root", "");
                
                if(request.getParameter("delete") == null){
                    if(request.getParameter("user") == null && request.getParameter("name") == null){
                        //ユーザー名の記入がない&商品名の記入がない
                        RequestDispatcher rsLogin = request.getRequestDispatcher("/DB_operation_13/Login.jsp");
                        rsLogin.forward(request, response);
                    } else if(request.getParameter("name") == null) {
                        //商品名の記入がない(ログイン時)
                        ps = co.prepareStatement("SELECT * FROM userdata ");
                        rs = ps.executeQuery();
                        rs.next();
                
                        String usertype = request.getParameter("user");
                        int password = Integer.valueOf(request.getParameter("password"));
                    
                        if(usertype.equals(rs.getString(2)) && password == rs.getInt(3)){
                            //商品登録JSPに移動
                            User user = new User(rs.getString(2), rs.getInt(3));
                            HttpSession hs = request.getSession();
                            hs.setAttribute("user", user);
                        
                            co.close();
                            ps.close();
                            rs.close();
                            RequestDispatcher rsCR = request.getRequestDispatcher("/DB_operation_13/CommodityRegistration.jsp");
                            rsCR.forward(request, response);
                        } else {
                            Error er = new Error(1);
                            request.setAttribute("login", er);
                            //Login.jspに戻る
                            RequestDispatcher rsLogin = request.getRequestDispatcher("/DB_operation_13/Login.jsp");
                            rsLogin.forward(request, response);
                        }
                    
                    } else {
                        ps = co.prepareStatement("SELECT * FROM commodities");
                        rs = ps.executeQuery();
                        
                        while(rs.next()){
                            if(rs.getString(2).equals(request.getParameter("name"))){
                                //商品名が同じならば値を更新
                                ps = co.prepareStatement("UPDATE commodities SET name = ?,number = ?, price = ?, genre = ? WHERE name = ?");
                                ps.setString(1, request.getParameter("name"));
                                int num = Integer.valueOf(request.getParameter("number")) + rs.getInt(3);
                                ps.setInt(2, num);
                                ps.setInt(3, Integer.valueOf(request.getParameter("price")));
                                ps.setString(4, request.getParameter("genre"));
                                ps.setString(5, request.getParameter("name"));
                                int eu = ps.executeUpdate();
                                co.close();
                                ps.close();
                                rs.close();
                                //商品リストjspに移動
                                RequestDispatcher rsList = request.getRequestDispatcher("/DB_operation_13/CommodityList.jsp");
                                rsList.forward(request, response);
                            } 
                        }
                        
                        //商品名がデータベース上に存在しない
                        ps = co.prepareStatement("SELECT MIN(commodityID + 1) FROM commodities WHERE (commodityID + 1) NOT IN (SELECT commodityID FROM commodities)");
                        rs = ps.executeQuery();
                        rs.next();
                        int number = rs.getInt(1);
                    
                        ps = co.prepareStatement("INSERT INTO commodities VALUES (?, ?, ?, ?, ?)");
                        ps.setInt(1, number);
                        ps.setString(2, request.getParameter("name"));
                        ps.setInt(3, Integer.valueOf(request.getParameter("number")));
                        ps.setInt(4, Integer.valueOf(request.getParameter("price")));
                        ps.setString(5, request.getParameter("genre"));
                        int eu = ps.executeUpdate();
                        co.close();
                        ps.close();
                        rs.close();
                        //商品リストjspに移動
                        RequestDispatcher rsList = request.getRequestDispatcher("/DB_operation_13/CommodityList.jsp");
                        rsList.forward(request, response);
                    }
                } else {
                    ps = co.prepareStatement("DELETE FROM commodities WHERE commodityID = ?");
                    ps.setInt(1, Integer.valueOf(request.getParameter("delete")));
                    int eu = ps.executeUpdate();
                    
                    co.close();
                    ps.close();
                    //商品リストjspに移動
                    RequestDispatcher rsList = request.getRequestDispatcher("/DB_operation_13/CommodityList.jsp");
                    rsList.forward(request, response);
                }

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
           
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
