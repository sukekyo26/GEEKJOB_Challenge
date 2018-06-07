/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardClass09;
import java.io.*;
/**
 *
 * @author sumi3
 */
public class StandardClass09 {
    public static void main(String[] args) throws IOException{
        //ファイルパス
        File fp = new File("C:\\Users\\sumi3\\Documents\\GEEKJOB_Challenge\\CampChallenge_java\\015.標準クラス\\StandardClass08\\profile.txt");
        //FileReader
        FileReader fr = new FileReader(fp);
        //BufferedReader
        BufferedReader br = new BufferedReader(fr);
        //
        System.out.println(br.readLine());
    }    
}
