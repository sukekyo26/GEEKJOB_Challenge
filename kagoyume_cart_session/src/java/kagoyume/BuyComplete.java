/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author sumi3
 */
public class BuyComplete extends HttpServlet {

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
        ArrayList<Integer> li = new ArrayList<Integer>();
        try {
            
            String accesschk = request.getParameter("ac");//不正なアクセスチェック
            if(accesschk == null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            BuyDataDTO bdd = new BuyDataDTO();
            int type = Integer.parseInt(request.getParameter("type"));//発送方法をパラメータで受けとる
            UserDataDAO.getInstance().UpdateUserTotalPurchase(udd, ci);//総購入金額を更新
            bdd.setUserID(udd.getUserID());//BuyDataDTOにユーザーIDを格納
            for(int count = 0; count < ci.getItemSize(); count++){
                if(ci.getUserID(count) == udd.getUserID()){
                    bdd.setItemCode(ci.getItemCode(count));
                    bdd.setType(type);
                    bdd.setItemNumber(ci.getItemNumber(count));
                    li.add(count);
                }
            }
            for(int a = 0; a < li.size(); a++){
                ci.removeItem(li.get(0));//購入したカート内のアイテムを削除。削除していくと番号がずれていくので0を削除で固定
            }
            BuyDataDAO.getInstance().newBuyDataInsert(bdd);
            if(ci.getItemSize() == 0){
                session.removeAttribute("CartItem");//カートに何もなければセッションごと削除
            }
            request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);
        } catch (Exception e){
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
