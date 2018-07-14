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
public class Item extends HttpServlet {

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
        SearchResult sr = (SearchResult)session.getAttribute("SearchResult");
        CartItem ci = (CartItem)session.getAttribute("CartItem");
        try {
            SelectItem ckitem = new SelectItem();
            if(request.getParameter("previous") != null && request.getParameter("previous").equals("cart")){
                //cart.jspから来た場合の処理
                int num = Integer.parseInt(request.getParameter("itemID"));
                ckitem.allSet(ci.getName(num), ci.getDescription(num), ci.getThumnail(num), ci.getLargeThumnail(num), ci.getPrice(num), ci.getRate(num), ci.getItemCode(num));
                session.setAttribute("SelectItem", ckitem);
                request.getRequestDispatcher("./item.jsp").forward(request, response);
                return;
            }
            
            int num = Integer.valueOf(request.getParameter("id"));
            ckitem.allSet(sr.getName(num), sr.getDescription(num), sr.getThumnail(num), sr.getLargeThumnail(num), sr.getPrice(num), sr.getRate(num), sr.getItemCode(num));
            
            session.setAttribute("SelectItem", ckitem);
            //リクエストスコープにクリックした商品情報をセット
            request.getRequestDispatcher("./item.jsp").forward(request, response);
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
