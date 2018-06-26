package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        UserDataDTO udd = (UserDataDTO)session.getAttribute("resultDetail");
        //UserDataBeans udb = (UserDataBeans)session.getAttribute("udbData");
        try {
            String accessCheck = request.getParameter("check");
            if(accessCheck == null || (Integer)session.getAttribute("check") != Integer.parseInt(accessCheck)){
                throw new Exception("不正なアクセスです");
            }
            
            
            UserDataBeans newUdb = new UserDataBeans();
            if(request.getParameter("name").equals("")){
                newUdb.setName(udd.getName());
            }else{
                newUdb.setName(request.getParameter("name"));
            }
            if(request.getParameter("tell").equals("")){
                newUdb.setTell(udd.getTell());
            }else{
                newUdb.setTell(request.getParameter("tell"));
            }
            if(request.getParameter("comment").equals("")){
                newUdb.setComment(udd.getComment());
            }else{
                newUdb.setComment(request.getParameter("comment"));
            }
            
            newUdb.setYear(request.getParameter("year"));
            newUdb.setMonth(request.getParameter("month"));
            newUdb.setDay(request.getParameter("day"));
            newUdb.setType(request.getParameter("type"));
            UserDataDTO newUdd = new UserDataDTO();
            newUdb.UD2DTOMapping(newUdd); //UserDataBeans(newUdb)のデータをUserDataDTO(newUdd)に変換
            newUdd.setUserID(udd.getUserID());//ユーザーIDをnewUddに挿入
            UserDataDAO.getInstance().updateData(newUdd);//SQLのUPDATEを実行
            
            
            session.removeAttribute("resultData");//セッション(resultData)を破棄
            request.setAttribute("updateData", newUdd);//newリクエストスコープ(updateData){UserDataDTOの更新情報}
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
        } catch(Exception e){
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
