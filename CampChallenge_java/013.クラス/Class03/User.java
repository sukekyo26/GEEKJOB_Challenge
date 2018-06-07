/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class03;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sumi3
 */
public class User extends Human{
    public int open(){
        int sum = 0;
        for(int ad = 0; ad < myCards.size(); ad++){
            sum += myCards.get(ad);
        }    
        return sum;
    }
    
    public void setCard(ArrayList<Integer> n){
        for(int a = 0; a < n.size(); a++){
            myCards.add(n.get(a));
        } 
    }
    
    public boolean checkSum(){
        Random r = new Random();  
        if(open() <= 11){
            return true;
        } else if(open() <= 17){
            for(int a = 0; a <myCards.size(); a++){
                boolean b= (myCards.get(a) < 4);
                if (b == true){
                    return false;
                } else {
                    return r.nextBoolean();
                } 
            }    
        }
        return false;     
    }    
}
