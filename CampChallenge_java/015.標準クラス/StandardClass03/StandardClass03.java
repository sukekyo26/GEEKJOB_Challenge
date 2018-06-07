/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardClass03;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sumi3
 */
public class StandardClass03 {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.set(2016, 10, 4, 10, 0, 0);
        
        System.out.println(c.getTime());
        
        Date d = c.getTime();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.print(sdf.format(d));
    }    
}
