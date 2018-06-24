package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Calendar;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException, ParseException{
        Connection con = null;
        PreparedStatement st = null;
        ArrayList<UserDataDTO> dataList = new ArrayList<UserDataDTO>();
        try{
            con = DBManager.getConnection();
            
            
            String sql = "SELECT * FROM user_t";
            boolean flag = false;
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
            }
            if (ud.getBirthday()!=null) {
                if(!flag){
                    sql += " WHERE birthday like ?";
                    flag = true;
                }else{
                    sql += " AND birthday like ?";
                }
            }
            if (ud.getType()!=0) {
                if(!flag){
                    sql += " WHERE type like ?";
                }else{
                    sql += " AND type like ?";
                }
            }
            st =  con.prepareStatement(sql);
            int count = 1;
            
            if (!ud.getName().equals("")) {
                st.setString(count, "%"+ud.getName()+"%");
                count++;
            }
            
            if(ud.getBirthday()!=null){
                st.setString(count, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                count++;
            }
            
            if(ud.getType() != 0) {
                st.setInt(count, ud.getType());
                
            } 
            
            ResultSet rs = st.executeQuery();
            //DateはsqlDate(タイムスタンプ)なのでjava.util.Dateに変換
            while(rs.next()){
                UserDataDTO resultUd = new UserDataDTO();
                Date date = new Date(rs.getDate(3).getTime());
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(date);
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
                dataList.add(resultUd);
            }
                
            System.out.println("search completed");

            return dataList;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            Date date = new Date(rs.getDate(3).getTime());
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(date);
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * 指定ユーザーのデータの更新を行う。
     * 一応未記入にも対応出来るようにしたが、値をすべてセットしてからこのメソッドを呼び出してるので生かされてない
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * 戻り値は必要ないのでvoid
     */
    public void updateData(UserDataDTO udd) throws SQLException{
    //

        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = DBManager.getConnection();
            String sql = "UPDATE user_t";
            boolean flag = false;
            
            //名前、電話番号、自己紹介が未記入の場合の処理
            if(!udd.getName().equals("")) {
                sql += " SET name = ?";
                flag = true;
            }
            if(!udd.getTell().equals("")) {
                if(flag) {
                    sql += ", tell = ?";
                }else {
                    sql += " SET tell = ?";
                    flag = true;
                }
            }
            if(!udd.getComment().equals("")) {
                if(flag) {
                    sql += ", comment = ?";
                } else {
                    sql += " SET comment = ?";
                    flag = true;
                }
            }
            
            //誕生日と種別を未記入にすることは物理的に不可能なので別に追加
            if(flag){
                sql += ", birthday = ?, type = ?";
            } else {
                sql += " SET birthday = ?, type = ?";
            }
            sql += " WHERE userID = ?";//ユーザー指定
            
            ps = con.prepareStatement(sql);
            int count = 1;
            if(!udd.getName().equals("")) {
                ps.setString(count, udd.getName());
                count++;
            }
            if(!udd.getTell().equals("")) {
                ps.setString(count, udd.getTell());
                count++;
            }
            if(!udd.getComment().equals("")) {
                ps.setString(count, udd.getComment());
                count++;
            }
            //java.util.Dateからjava.sql.Dateに変換
            Calendar cal = Calendar.getInstance();
            cal.setTime(udd.getBirthday());
            cal.set(Calendar.HOUR_OF_DAY,0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            ps.setDate(count, new java.sql.Date(cal.getTimeInMillis()));
            count++;
            ps.setInt(count, udd.getType());
            count++;
            ps.setInt(count, udd.getUserID());
            
            ps.executeUpdate();//SQL実行
            System.out.println("updateData completed");
            
        }catch(Exception e){
            System.out.print(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }    
     /**
     * 指定ユーザーIDのデータの削除を行う。
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * 戻り値は必要ないのでvoid
     */
    public void deleteUserData(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = DBManager.getConnection();
            String sql = "DELETE FROM user_t WHERE userID = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, udd.getUserID());//ここ
            
            ps.executeUpdate();//sql実行
            System.out.println("deleteUserData completed");
            
        } catch(Exception e) {
            System.out.print(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }    
        }
    }
}

