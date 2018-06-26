package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class SearchResult extends HttpServlet {

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
            

            //DeleteResult.jspから戻ってきた場合の処理と
            if(request.getParameter("search") != null && request.getParameter("search").equals("検索結果に戻る") || session.getAttribute("resultDetail") != null) {
                //セッション(resultDetail)にデータが残っていた場合、例えばAさんの詳細情報から検索結果に戻った時にBさんの詳細情報を見ようとするとAさん情報が表示されてしまうのでここで削除
                if(session.getAttribute("resultDetail") != null) session.removeAttribute("resultDetail");
                UserDataDTO beforeSearchData = (UserDataDTO)session.getAttribute("searchDataDTO");
                ArrayList<UserDataDTO> updateSearchData = UserDataDAO.getInstance().search(beforeSearchData);//前回検索した項目に一致するデータを再度検索
                request.setAttribute("searchResultData", updateSearchData);//リクエストスコープ(searchResultData)
                request.getRequestDispatcher("/searchresult.jsp").forward(request, response); 
                return;
            }
            
            
            //フォームからの入力を取得して、JavaBeansに格納
            UserDataBeans udb = new UserDataBeans();
            udb.setName(request.getParameter("name"));
            udb.setYear(request.getParameter("year"));
            udb.setType(request.getParameter("type"));
            

            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO searchData = new UserDataDTO();
            udb.UD2DTOMapping(searchData);//これでUserDataBeansのudbの値をUserDataDTOのsearchDataに格納
            session.setAttribute("searchDataDTO", searchData);//newセッション(searchDataDTO){search.jspで入力した項目をUserDataDTOとして保持}
            
            ArrayList<UserDataDTO> resultData = UserDataDAO.getInstance().search(searchData);
            //リクエストからセッションに変更
            request.setAttribute("searchResultData", resultData);//newセッション(searchResultData){検索した項目に一致するデータをArrayListとして保持する}
            
            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);
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
