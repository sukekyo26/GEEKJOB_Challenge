/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class03_1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Class03_1.Dealer;
import Class03_1.Human;
import Class03_1.User;

/**
 *
 * @author sumi3
 */
public class BlackJack extends HttpServlet {

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
            out.println("<title>Servlet BlackJack</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //ディーラーインスタンス作成
            Dealer tonegawa = new Dealer();
            //ユーザーインスタンス作成
            User kaiji = new User();
            //ユーザーにディーラーがカードを2枚配る
            kaiji.setCard(tonegawa.deal());
            //ディーラーにディーラーがカードを2枚配る
            tonegawa.setCard(tonegawa.deal());
            //ユーザーが新しくカードを引くかどうか
            while(kaiji.checkSum() == true){
                out.println("プレイヤーの現在の得点は" + kaiji.open() + "点です<br>");
                out.println("プレイヤーがヒットを宣言しました<br>");
                kaiji.setCard(tonegawa.hit());
            }
            //プレイヤーがバストしたかどうか
            if(kaiji.open() > 21){
                out.println("プレイヤーがバストした為プレイヤーの負けです。<br>");
                out.println("プレイヤーの得点は" + kaiji.open() +"点です<br>");

            } else {
                out.println("プレイヤーがスタンドを宣言しました<br>");
                //ディーラーが新しくカードを引くかどうか
                while(tonegawa.checkSum() == true){
                    out.println("ディーラーの現在の得点は" + tonegawa.open() + "点です<br>");
                    out.println("ディーラーがヒットを宣言しました<br>");
                    tonegawa.setCard(tonegawa.hit());
                }
                //ディーラーがバストしたかどうか
                if(tonegawa.open() > 21){
                    out.println("ディーラ－がバストした為プレイヤーの勝利です<br>");
                    out.println("プレイヤーの得点は" + kaiji.open() +"点です<br>");
                    out.println("ディーラーの得点は" + tonegawa.open() + "点です<br>");
                } else {
                    out.println("ディーラーがスタンドを宣言しました<br>");
                    //プレイヤーとディーラーの得点比較
                    if(tonegawa.open() > kaiji.open()){
                        out.println("プレイヤーの得点は" + kaiji.open() +"点です<br>");
                        out.println("ディーラーの得点は" + tonegawa.open() + "点です<br>");
                        out.println("ディーラーの得点がプレイヤーの得点を上回ったのでディーラーの勝利です<br>");
                    } else if(tonegawa.open() == kaiji.open()) {
                        out.println("プレイヤーの得点は" + kaiji.open() +"点です<br>");
                        out.println("ディーラーの得点は" + tonegawa.open() + "点です<br>");
                        out.println("ディーラーの得点とプレイヤーの得点が同値なので引き分けです<br>");
                    } else {
                        out.println("プレイヤーの得点は" + kaiji.open() +"点です<br>");
                        out.println("ディーラーの得点は" + tonegawa.open() + "点です<br>");
                        out.println("プレイヤーの得点がディーラーの得点を上回ったのでプレイヤーの勝利です<br>");
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
