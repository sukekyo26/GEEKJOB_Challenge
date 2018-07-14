package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kagoyume.TopError;
import kagoyume.UserDataDTO;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    TopError te = (TopError)request.getAttribute("TopError");
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>かごゆめ</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>かごゆめ</h1>\n");
      out.write("        ");
if(udd != null){
      out.write("\n");
      out.write("        ようこそ<a href=\"MyData\">");
      out.print(udd.getName());
      out.write("</a>さん!   <a href=\"Login?set=logout\">ログアウト</a>   <a href=\"Cart\">買い物かご</a>\n");
      out.write("        ");
}else{
      out.write("\n");
      out.write("        <font size=\"4\"><a href=\"Login?previous=top\"><strong>ログイン</strong></a></font>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <form action=\"Search\" method=\"GET\">\n");
      out.write("            \n");
      out.write("            <h2>\n");
      out.write("                \"あなたが望む商品を購入可能です。\"<br>\n");
      out.write("                \"購入代金は一切かかりません。\"<br>\n");
      out.write("                \"夢のショッピングサイトへようこそ。\"<br>\n");
      out.write("            </h2>\n");
      out.write("            <br>\n");
      out.write("            <h3>--------検索--------</h3>\n");
      out.write("            <p>キーワード検索(必須)</p>\n");
      out.write("            <input type=\"text\" name=\"search\" value=\"");
if(te != null && te.getKeyword() != null){out.print(te.getKeyword());}
      out.write("\"><br>\n");
      out.write("            ");
if(te != null && !te.getMarkCheck()){
      out.write("<font color=\"red\">");
out.print("＊検索キーワードを入力してください＊");
      out.write("</font>");
}
      out.write("\n");
      out.write("            <p>カテゴリ検索</p>\n");
      out.write("            <select name=\"category_id\">\n");
      out.write("                <option value=\"1\" selected>すべてのカテゴリ</option>\n");
      out.write("                <option value=\"13457\">ファッション</option>\n");
      out.write("                <option value=\"2498\">食品</option>\n");
      out.write("                <option value=\"2513\">アウトドア、釣り、旅行用品</option>\n");
      out.write("                <option value=\"2500\">ダイエット、健康</option>\n");
      out.write("                <option value=\"2501\">コスメ、美容、ヘアケア</option>\n");
      out.write("                <option value=\"2502\">スマホ、タブレット、パソコン</option>\n");
      out.write("                <option value=\"2504\">テレビ、オーディオ、カメラ</option>\n");
      out.write("                <option value=\"2505\">家電</option>\n");
      out.write("                <option value=\"2506\">家具、インテリア</option>\n");
      out.write("                <option value=\"2507\">花、ガーデニング</option>\n");
      out.write("                <option value=\"2508\">キッチン、日用品、文具</option>\n");
      out.write("                <option value=\"2503\">DIY、工具、ガーデニング</option>\n");
      out.write("                <option value=\"2509\">ペット用品、生き物</option>\n");
      out.write("                <option value=\"2510\">楽器、手芸、コレクション</option>\n");
      out.write("                <option value=\"2511\">ゲーム、おもちゃ</option>\n");
      out.write("                <option value=\"2497\">ベビー、キッズ、マタニティ</option>\n");
      out.write("                <option value=\"2512\">スポーツ</option>\n");
      out.write("                <option value=\"2514\">車、バイク、自転車</option>\n");
      out.write("                <option value=\"2516\">CD、音楽ソフト</option>\n");
      out.write("                <option value=\"2517\">DVD、映像ソフト</option>\n");
      out.write("                <option value=\"10002\">本、雑誌、コミック</option>\n");
      out.write("                <option value=\"47727\">レンタル、各種サービス</option>\n");
      out.write("            </select>\n");
      out.write("            <p>ソート順</p>\n");
      out.write("            <select name=\"sort\">\n");
      out.write("                <option value=\"-score\" selected>おすすめ順(デフォルト)</option>\n");
      out.write("                <option value=\"+price\">価格安い順</option>\n");
      out.write("                <option value=\"-price\">価格高い順</option>\n");
      out.write("            </select>\n");
      out.write("            <p>最高金額指定(指定された金額よりも低価格の商品を表示します)(＊未記入可)</p>\n");
      out.write("            <input type=\"number\" name=\"highPrice\">\n");
      out.write("            <p>最低金額指定(指定された金額よりも高価格の商品を表示します)(＊未記入可)</p>\n");
      out.write("            <input type=\"number\" name=\"lowPrice\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\" value=\"検索\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
