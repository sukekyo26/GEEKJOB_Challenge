<%@page import="kagoyume.TopError" 
        import="kagoyume.UserDataDTO"%>
<%
    TopError te = (TopError)request.getAttribute("TopError");
    UserDataDTO udd = (UserDataDTO)session.getAttribute("loginUserData");
%>
<%-- 
    Document   : top
    Created on : 2018/06/24, 15:59:00
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>かごゆめ</title>
    </head>
    <body>
        <h1>かごゆめ</h1>
        <%if(udd != null){%>
        ようこそ<a href="MyData"><%=udd.getName()%></a>さん!   <a href="Login?set=logout">ログアウト</a>   <a href="Cart">買い物かご</a>
        <%}else{%>
        <font size="4"><a href="Login?previous=top"><strong>ログイン</strong></a></font>
        <%}%>
        <br>
        <form action="Search" method="GET">
            
            <h2>
                "あなたが望む商品を購入可能です。"<br>
                "購入代金は一切かかりません。"<br>
                "夢のショッピングサイトへようこそ。"<br>
            </h2>
            <br>
            <h3>--------検索--------</h3>
            <p>キーワード検索(必須)</p>
            <input type="text" name="search" value="<%if(te != null && te.getKeyword() != null){out.print(te.getKeyword());}%>"><br>
            <%if(te != null && !te.getMarkCheck()){%><font color="red"><%out.print("＊検索キーワードを入力してください＊");%></font><%}%>
            <p>カテゴリ検索</p>
            <select name="category_id">
                <option value="1" selected>すべてのカテゴリ</option>
                <option value="13457">ファッション</option>
                <option value="2498">食品</option>
                <option value="2513">アウトドア、釣り、旅行用品</option>
                <option value="2500">ダイエット、健康</option>
                <option value="2501">コスメ、美容、ヘアケア</option>
                <option value="2502">スマホ、タブレット、パソコン</option>
                <option value="2504">テレビ、オーディオ、カメラ</option>
                <option value="2505">家電</option>
                <option value="2506">家具、インテリア</option>
                <option value="2507">花、ガーデニング</option>
                <option value="2508">キッチン、日用品、文具</option>
                <option value="2503">DIY、工具、ガーデニング</option>
                <option value="2509">ペット用品、生き物</option>
                <option value="2510">楽器、手芸、コレクション</option>
                <option value="2511">ゲーム、おもちゃ</option>
                <option value="2497">ベビー、キッズ、マタニティ</option>
                <option value="2512">スポーツ</option>
                <option value="2514">車、バイク、自転車</option>
                <option value="2516">CD、音楽ソフト</option>
                <option value="2517">DVD、映像ソフト</option>
                <option value="10002">本、雑誌、コミック</option>
                <option value="47727">レンタル、各種サービス</option>
            </select>
            <p>ソート順</p>
            <select name="sort">
                <option value="-score" selected>おすすめ順(デフォルト)</option>
                <option value="+price">価格安い順</option>
                <option value="-price">価格高い順</option>
            </select>
            <p>最高金額指定(指定された金額よりも低価格の商品を表示します)(＊未記入可)</p>
            <input type="number" name="highPrice">
            <p>最低金額指定(指定された金額よりも高価格の商品を表示します)(＊未記入可)</p>
            <input type="number" name="lowPrice">
            <br>
            <br>
            <input type="submit" value="検索">
        </form>
    </body>
</html>
