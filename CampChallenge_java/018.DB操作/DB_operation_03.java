/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_operation_03;

import java.sql.*;
/**
 *
 * @author sumi3
 */
public class DB_operation_03 {
    public static void main (String[] args){
        Connection db_co = null;
        PreparedStatement db_ps = null;
        ResultSet db_rs = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //DriverManagerクラスのgetConnectionメソッドを利用
            db_co = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?CharacterEncording=UTF-8&serverTimezone=JST", "root", "");
            //ConnectionクラスのprepareStatementメソッドを利用
            db_ps = db_co.prepareStatement("SELECT * FROM profiles");
            //PreparedStatemaentクラスのexecuteQueryメソッドを利用
            db_rs = db_ps.executeQuery();
            //ResultSetクラスのnext,getStringメソッドを利用
            while (db_rs.next()){
                System.out.print("ID: " + db_rs.getString("profilesID") + " ");
                System.out.print("名前: " + db_rs.getString("name") + " ");
                System.out.print("電話番号: " + db_rs.getString("tel") + " ");
                System.out.print("年齢: " + db_rs.getString("age") + " ");
                System.out.println("誕生日: " + db_rs.getString("birthday"));
            }
            //Connection, PreparedStatement,ResultSetを閉じる
            db_co.close();
            db_ps.close();
            db_rs.close();
        } catch(SQLException e_sql) { 
            System.out.println("接続時にエラーが発生しました：" + e_sql.toString());
        } catch(Exception e) {   
            System.out.println("接続時にエラーが発生しました：" + e);
        } finally {
            if (db_co != null){
                try{
                    db_co.close();
                } catch (Exception e_co) {
                    System.out.println(e_co.getMessage());
                }   
            }
            if (db_ps != null){
                try{
                    db_co.close();
                } catch (Exception e_ps) {
                    System.out.println(e_ps.getMessage());
                }   
            }    
            if (db_rs != null){
                try{
                    db_co.close();
                } catch (Exception e_rs) {
                    System.out.println(e_rs.getMessage());
                }   
            }    
        }
    }    
}
