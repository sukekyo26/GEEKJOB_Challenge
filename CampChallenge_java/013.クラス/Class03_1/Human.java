/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class03_1;

import java.util.ArrayList;

/**
 *
 * @author sumi3
 */
abstract public class Human {
    abstract public int open();
    abstract public void setCard(ArrayList<Integer> n);
    abstract public boolean checkSum();
    ArrayList<Integer> myCards = new ArrayList<Integer>();
    
}