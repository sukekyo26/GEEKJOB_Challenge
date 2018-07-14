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
public class Add extends HttpServlet {

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
        //SearchResult sr = (SearchResult)session.getAttribute("SearchResult");
        SelectItem si = (SelectItem)session.getAttribute("selectItem");
        UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
        CartItem ci = (CartItem)session.getAttribute("CartItem");
        try {
            //カートに追加ボタンでここに来る。
            int itemNum = Integer.parseInt(request.getParameter("number"));
            if(ci == null){
                //セッション("CartItem")の中身がない＝初めてここに来た場合の処理
                CartItem nci = new CartItem(si.getName(), si.getThumnail(), si.getLargeThumnail(), si.getDescription(), si.getPrice(), si.getRate(), itemNum, si.getItemCode());
                if(udd != null){nci.updateUserID(0, udd.getUserID());}//この時点でログイン済の場合guestID:0をユーザーIDに更新
                session.setAttribute("CartItem", nci);//新セッション(CartItem)[カートの中身のセッション]
                request.getRequestDispatcher("/add.jsp").forward(request, response);
                return;
            }
            if(udd != null){//ログイン済の場合はユーザーIDを登録。ログイン済でない場合はguestID:0を登録
                if(ci.chkSameItem(si.getName(), itemNum, udd.getUserID())){
                    //ログイン済のユーザーが既に同じ名前の商品をカートに入れている場合個数のみを増やし、同じ名前の商品がカートになければ以下の処理を行う
                    ci.allSet(udd.getUserID(), si.getName(), si.getThumnail(), si.getLargeThumnail(), si.getDescription(), si.getPrice(), si.getRate(), itemNum, si.getItemCode());
                    //allSet(ユーザー名,商品名,商品画像,商品説明,商品価格,商品個数,商品コード)
                    session.setAttribute("CartItem", ci);
                }
            } else {
                if(ci.chkSameItem(si.getName(), itemNum, 0)){
                    //guest(ログインしていない人)が既に同じ名前の商品をカートに入れている場合個数のみを増やし、同じ名前の商品がカートになければ以下の処理を行う
                    ci.allSet(0, si.getName(), si.getThumnail(), si.getLargeThumnail(), si.getDescription(), si.getPrice(), si.getRate(), itemNum, si.getItemCode());
                    session.setAttribute("CartItem", ci);
                }
            }
            
            request.getRequestDispatcher("/add.jsp").forward(request, response);
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
