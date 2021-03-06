/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_operation_06;
import java.sql.*;

/**
 *
 * @author sumi3
 */
public class DB_operation_06 {
    public static void main (String[] args) {
        Connection db_co = null;
        PreparedStatement db_ps = null;
        ResultSet db_rs = null;
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_co = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?CharacterEncording=UTF-8&serverTimezone=JST", "root", "");
            db_ps = db_co.prepareStatement("DELETE FROM profiles WHERE profilesID = ?");
            db_ps.setInt(1, 6);
            //DELETEを実行
            int eu = db_ps.executeUpdate();
            
            db_ps = db_co.prepareStatement("SELECT * FROM profiles");
            //SELECTを実行
            db_rs = db_ps.executeQuery();
            
            while(db_rs.next()){
                System.out.print("ID: " + db_rs.getString(1) + " ");
                System.out.print("名前: " + db_rs.getString(2) + " ");
                System.out.print("電話番号: " + db_rs.getString(3) + " ");
                System.out.print("年齢: " + db_rs.getString(4) + " ");
                System.out.println("誕生日: " + db_rs.getString(5) + " ");
            }    
            db_co.close();
            db_ps.close();
            db_rs.close();
        } catch(SQLException e_sql) {    
            System.out.print("接続時にエラーが発生しました：" + e_sql.toString());
        } catch(Exception e) {
            System.out.print("接続時にエラーが発生しました：" + e.toString());
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
                    db_ps.close();
                } catch (Exception e_ps) {
                    System.out.println(e_ps.getMessage());
                }
            }
            if (db_rs != null){
                try{
                    db_rs.close();
                } catch (Exception e_rs) {
                    System.out.println(e_rs.getMessage());
                }    
            }
        }   
    }    
}
