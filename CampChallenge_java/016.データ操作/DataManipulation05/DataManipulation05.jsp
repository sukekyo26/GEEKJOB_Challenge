<%-- 
    Document   : DataManipulation05
    Created on : 2018/06/10, 19:11:55
    Author     : sumi3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int num = Integer.valueOf(request.getParameter("number"));
            String tw = "", th = "", fi = "", se="";
            int sum = num;
            //２で割れるかどうか
            while (sum % 2 == 0){
                int quo = sum / 2;
                if (sum / 2 == 1 || quo % 2 != 0 && sum % 3 != 0 && sum % 5 != 0 && sum % 7 != 0){
                    //sumが２である　または　sumが２のべき乗、２のべき乗×素数でなくかつ３，５，７で割り切れない
                    tw += "2";
                } else {
                    tw += "2 * ";
                }
                sum /= 2;
            }
            
            //３で割れるかどうか
            while (sum % 3 == 0){
                int quo = sum / 3;
                if(sum / 3 == 1 || quo % 3 != 0 && sum % 5 != 0 && sum % 7 != 0){
                    //sumが３である または　sumが３のべき乗、３のべき乗×素数でないかつ５，７で割り切れない
                    th += "3";
                } else {   
                    th += "3 * ";
                }
                sum /= 3;
            }
            
            //５で割れるかどうか
            while (sum % 5 == 0){
                int quo = sum / 5;
                if(sum / 5 == 1 || quo % 5 != 0 && sum % 7 != 0){
                    //sumが５である または　sumが５のべき乗、５のべき乗×素数でないかつ７で割り切れない
                    fi += "5";
                } else {   
                    fi += "5 * ";
                }    
                sum /= 5;
            }
            
            //７で割れるかどうか
            while (sum % 7 == 0){
                int quo = sum / 7;
                if(sum / 7 == 1 || quo % 7 != 0){
                    se += "7";
                } else {
                    se += "7 * ";
                }
                sum /= 7;
            }
            
            
            if(sum == num){
                //素数かどうか
                out.print(num + "は素数です");
            } else if (sum == 1){
                //余りがない
                out.print(num + " = " + tw + th + fi + se);
            } else {
                //余りがある
                out.print(num + " = " + tw + th + fi + se + " あまり " + sum);
            }   
            
        %>
    </body>
</html>