/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_operation_09;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.Date;

/**
 *
 * @author sumi3
 */
public class DB_operation_09 extends HttpServlet {

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
            out.println("<title>Servlet DB_operation_09</title>");            
            out.println("</head>");
            out.println("<body>");
            
            request.setCharacterEncoding("UTF-8");
            Connection co = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                co = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?CharacterEncording=UTF-8&serverTimezone=JST", "root", "");
                
                ps = co.prepareStatement("SELECT MIN(profilesID + 1) FROM profiles WHERE (profilesID + 1) NOT IN (SELECT profilesID FROM profiles)");
                rs = ps.executeQuery();
                rs.next();
                int number = rs.getInt(1);
                
                ps = co.prepareStatement("INSERT INTO profiles VALUES(?, ?, ?, ?, ?)");
                ps.setInt(1, number);
                ps.setString(2, request.getParameter("name"));
                ps.setString(3, request.getParameter("tel"));
                ps.setInt(4, Integer.valueOf(request.getParameter("age")));
                Date sqlDate = Date.valueOf(request.getParameter("birthday"));
                ps.setDate(5, sqlDate);
                int eu = ps.executeUpdate();
                
                ps = co.prepareStatement("SELECT * FROM profiles ORDER BY profilesID ASC");
                rs = ps.executeQuery();
                while(rs.next()){
                    out.print("ID: " + rs.getString(1) + " ");
                    out.print("名前: " + rs.getString(2) + " ");
                    out.print("電話番号: " + rs.getString(3) + " ");
                    out.print("年齢: " + rs.getString(4) + " ");
                    out.print("誕生日: " + rs.getString(5) + "<br>");
                }    
                
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
