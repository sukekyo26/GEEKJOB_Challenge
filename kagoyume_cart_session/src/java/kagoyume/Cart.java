/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sumi3
 */
public class Cart extends HttpServlet {

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
        HttpSession session = request.getSession();
        CartItem ci = (CartItem)session.getAttribute("CartItem");
        UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
        try {
            if(udd != null && ci != null){
                //ログイン済でカートにアイテムがある場合
                for(int a = 0; a < ci.getItemSize(); a++){
                    //カートに入れたユーザー名を登録
                    if(ci.getUserID(a) == 0){
                        //カートの商品を入れたユーザー名がguest（ID:0）の場合下の処理
                        if(ci.chkSameItem(ci.getName(a), ci.getItemNumber(a), udd.getUserID())){
                            //現在セッション(loginUserData)に格納されているユーザー名かつ商品名が同じものがカートに無い場合
                            ci.updateUserID(a, udd.getUserID());
                        } else {
                            //現在セッション(loginUserData)に格納されているユーザー名かつ商品名が同じものがカートにある場合、元から入っていたデータの個数を更新するので今追加した商品は消す
                            ci.removeItem(a);
                        } 
                    }
                    //削除ボタンを押したとき
                    if(request.getParameter("delete") != null && request.getParameter("delete").equals(String.valueOf(a))){
                        ci.removeItem(a);
                    }
                }
                request.getRequestDispatcher("/cart.jsp").forward(request, response);
                return;
            }
            if(request.getParameter("check") != null && udd == null){
                //add.jspから来たかつログインしていない
                LoginBeans lb = new LoginBeans();
                lb.setPreviosPage("Cart");
                lb.setNonLogin(true);
                request.setAttribute("nonLogin", lb);
                request.getRequestDispatcher("Login").forward(request, response);
                return;
            }
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
