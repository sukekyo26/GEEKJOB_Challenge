/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_operation_08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import java.util.HashMap;

/**
 *
 * @author sumi3
 */
public class DB_operation_08 extends HttpServlet {

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
            out.println("<title>Servlet DB_operation_08</title>");            
            out.println("</head>");
            out.println("<body>");
            
            request.setCharacterEncoding("UTF-8");
            Connection db_co = null;
            PreparedStatement db_ps = null;
            ResultSet db_rs = null;
            Profiles ps = new Profiles();
            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                db_co = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?CharacterEncording=UTF-8&serverTimezone=JST","root","");
                
                db_ps = db_co.prepareStatement("SELECT * FROM profiles WHERE name LIKE ?");
                String typename = request.getParameter("name");
                db_ps.setString(1, "%" + typename +"%");
                //SELECTを実行
                db_rs = db_ps.executeQuery();
                
                int count = 0;
                
                while(db_rs.next()){
                        count++;
                }
                db_rs.beforeFirst();
                for(int i = 1; i <= count ; i++){
                    db_rs.next();
                    String data = "ID: " + db_rs.getString(1) + " 名前: " + db_rs.getString(2) + " 電話番号: " + db_rs.getString(3) + " 年齢: " + db_rs.getString(4) + " 誕生日: " + db_rs.getString(5) + " " + "<br>";
                    ps.setData("n" + i, data);
                    out.print(ps.getData("n" + i));
                }
                
                if(db_rs.previous() == false & db_rs.next() == false) out.print("該当する人物データはありません");
 
                db_co.close();
                db_ps.close();
                db_rs.close();
            } catch (SQLException ex) {
                System.out.println("接続時にエラーが発生しました：" + ex.toString());
            } catch (Exception e) {
                System.out.println("接続時にエラーが発生しました：" + e.toString());
            } finally {   
                if (db_co != null){
                    try{
                        db_co.close();
                    } catch (Exception e_co) {    
                        System.out.println(e_co.getMessage());
                    }    
                } 
                if (db_ps != null){
                    try{
                        db_ps.close();
                    } catch (Exception e_ps) {    
                        System.out.println(e_ps.getMessage());
                    }    
                }
                if (db_rs != null){
                    try{
                        db_rs.close();
                    } catch (Exception e_rs) {    
                        System.out.println(e_rs.getMessage());
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
 
