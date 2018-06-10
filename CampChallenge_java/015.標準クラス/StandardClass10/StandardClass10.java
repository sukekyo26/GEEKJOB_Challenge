/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardClass10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author sumi3
 */
public class StandardClass10 extends Thread{
     public static void main(String[] args) throws IOException{
        //ファイルパス
        File fr = new File("C:\\Users\\sumi3\\Documents\\GEEKJOB_Challenge\\CampChallenge_java\\015.標準クラス\\StandardClass10\\log.txt");
        //FileWriter作成
        FileWriter fw = new FileWriter(fr);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("処理の内容：Timerクラスを利用して「私の名前は」、「S.Kです」、「よろしくお願いします」という3つの文節を2秒間隔で追加していく");
        bw.newLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Timer tm = new Timer();
        TimerTask task = new TimerTask(){ 
            int a = 0;
            public void run(){
                
                if(a == 0){
                    System.out.println("私の名前は");
                }else if(a == 1){
                    System.out.println("S.Kです");
                }else {
                    System.out.println("よろしくお願いします");
                }
                a++;
                
                if(a >= 3) {
                    File fr = new File("C:\\Users\\sumi3\\Documents\\GEEKJOB_Challenge\\CampChallenge_java\\015.標準クラス\\StandardClass10\\log.txt");
                    FileWriter fw;
                    try {
                        //終了時刻
                        fw = new FileWriter(fr, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        Date end = new Date();
                        bw.write("処理を終了します。" + "時刻：" + sdf.format(end));
                        bw.newLine();
                        bw.close();
                        //タイマーストップ
                        tm.cancel();
                    } catch (IOException ex) {
                        System.out.print("書き込みできませんでした");
                    }   
                }
            }
        };
        
        //開始時刻
        Date start = new Date();
        bw.write("処理を開始します。時刻：" + sdf.format(start));
        bw.newLine();
        bw.close();
        
        //2秒間隔でtaskを実行
        tm.schedule(task, 0,2000);
    }
}
