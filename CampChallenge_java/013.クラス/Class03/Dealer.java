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

public class Dealer extends Human{
    
    protected ArrayList<Integer> cards = new ArrayList<Integer>();
    
    public Dealer(){
        for (int four = 1; four <= 4; four++){
            for(int card = 1; card <= 13; card++){
                if(card <= 10){
                    cards.add(card);
                }else{
                    cards.add(10);
                }
            }    
        }        
    }
    
    public ArrayList<Integer> deal(){
        ArrayList<Integer> hold = new ArrayList<Integer>();
        Random rand = new Random();
        for(int two = 1; two <= 2; two++){
            Integer index = rand.nextInt(cards.size());
            hold.add(cards.get(index));
            cards.remove(index);
        }
        return hold;
    }
    
    public ArrayList<Integer> hit(){
        ArrayList<Integer> ad = new ArrayList<Integer>();
        Random rand = new Random();
        Integer index = rand.nextInt(cards.size());
        ad.add(cards.get(index));
        cards.remove(index);
        return ad;
    }

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
        if (open() <= 17){
            return true;
        } else {
            return false;
        }
    } 
}






