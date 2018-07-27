/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_operation_02;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.sql.Date;
/**
 *
 * @author sumi3
 */

public class DB_operation_02 {
    public static void main(String[] args){
        Connection db_co = null;
        PreparedStatement db_ps = null;
       
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date sqlDate = new Date(sdf.parse("1992-07-26").getTime());
            
            db_co = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?CharacterEncording=UTF-8&serverTimezone=JST","root","");
            db_ps = db_co.prepareStatement("INSERT INTO profiles VALUES(?, ?, ?, ?, ?)");
            db_ps.setInt(1, 6);
            db_ps.setString(2, "山田 太郎");
            db_ps.setString(3, "000-351-2137");
            db_ps.setInt(4, 25);
            db_ps.setDate(5, sqlDate);
            
            int eu = db_ps.executeUpdate();
            
            db_co.close();
            db_ps.close();
        } catch(SQLException e_sql){
            System.out.println("接続時にエラーが発生しました：" + e_sql.toString());
        } catch(Exception e){
            System.out.println("接続時にエラーが発生しました：" + e.toString());
        } finally {
            if(db_co != null){
                try{
                    db_co.close();
                } catch(Exception e_co){
                    System.out.println(e_co.getMessage());
                }    
            }
            if(db_ps != null){
                try{
                    db_ps.close();
                } catch(Exception e_ps) {
                    System.out.println(e_ps.getMessage());
                }    
            }    
        }    
    }    
}
