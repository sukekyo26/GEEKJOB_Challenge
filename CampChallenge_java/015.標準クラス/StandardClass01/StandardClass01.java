/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardClass01;
import java.util.Date;
import java.util.Calendar;
/**
 *
 * @author sumi3
 */
public class StandardClass01 {

    public static void main(String[] args){
        Calendar a = Calendar.getInstance();
        //2016年1月1日 0時0分0秒
        a.set(2016, 0, 1, 00, 00, 00);
        Date e = a.getTime();
        System.out.println(e.getTime());
        
    }
}    

