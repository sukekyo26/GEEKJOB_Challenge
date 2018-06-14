/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_operation_01;
import java.sql.*;
/**
 *
 * @author sumi3
 */
public class DB_operation_01 {
    public static void main(String[] args){
        Connection db_co = null;
    PreparedStatement db_ps = null;
    ResultSet db_rs = null;
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
            db_co = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncording=UTF-8&serverTimezone=JST", "root", "");
        
            db_co.close();
        } catch (SQLException ex_sql){
            System.out.println("接続時にエラーが発生しました：" + ex_sql.toString());
        } catch(Exception e){  
            System.out.println("接続時にエラーが発生しました：" + e.toString());
        } finally {
            if(db_co != null){
                try{
                    db_co.close();
                } catch(Exception e_con){
                    System.out.println(e_con.getMessage());
                }    
            }    
        }   
    }
}
