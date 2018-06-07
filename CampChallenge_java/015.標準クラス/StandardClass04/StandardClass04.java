/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardClass04;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author sumi3
 */
public class StandardClass04 {
    public static void main(String[] args){
        Calendar a = Calendar.getInstance();
        Calendar b = Calendar.getInstance();
        a.set(2015, 0, 1, 0, 0, 0);
        b.set(2015, 11, 31, 23, 59, 59);
        Date c = a.getTime(); 
        Date d = b.getTime();
        System.out.println(b.getTime().getTime() - a.getTime().getTime());
                
    }    
}
