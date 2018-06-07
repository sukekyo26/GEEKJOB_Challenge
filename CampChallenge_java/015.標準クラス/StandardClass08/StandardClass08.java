/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardClass08;
import java.io.*;

/**
 *
 * @author sumi3
 */
public class StandardClass08 {
    public static void main(String[] args) throws IOException{
        //ファイル作成
        File fp = new File("C:\\Users\\sumi3\\Documents\\GEEKJOB_Challenge\\CampChallenge_java\\015.標準クラス\\StandardClass08\\profile.txt");
        
        //FileWriter作成
        FileWriter fw = new FileWriter(fp);
        fw.write("よろしくお願いします!");
        fw.close();
    }    
}
