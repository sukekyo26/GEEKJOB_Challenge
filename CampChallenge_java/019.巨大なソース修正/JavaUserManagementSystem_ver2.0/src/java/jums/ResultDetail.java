package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class ResultDetail extends HttpServlet {

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
        HttpSession session = request.getSession();
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO searchData = new UserDataDTO();
            
            //updateresult.jspから戻ってきた場合の処理
            if(request.getParameter("back") != null && request.getParameter("back").equals("詳細情報に戻る") || session.getAttribute("resultDetail") != null) {
                if(session.getAttribute("resultDetail") != null){request.getRequestDispatcher("/resultdetail.jsp").forward(request, response); return;}
                searchData.setUserID(Integer.valueOf(request.getParameter("userId")));
                //UserDataDTO udd = (UserDataDTO)session.getAttribute("resultDetail");
                UserDataDTO updateData = UserDataDAO.getInstance().searchByID(searchData);//IDに対応したデータをセット
                session.setAttribute("resultDetail", updateData);//セッション(resultDetail)を再度更新
                request.getRequestDispatcher("/resultdetail.jsp").forward(request, response); 
                return;
            }   
            
            searchData.setUserID(Integer.valueOf(request.getParameter("id")));
            UserDataDTO resultData = UserDataDAO .getInstance().searchByID(searchData);
            session.setAttribute("resultDetail", resultData);//新セッション(resultDetail){クリックした人物のIDに対応するデータ情報}
            request.getRequestDispatcher("/resultdetail.jsp").forward(request, response);  
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
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
