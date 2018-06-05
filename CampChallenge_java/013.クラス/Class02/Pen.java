/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class02;

import Class01.*;

/**
 *
 * @author sumi3
 */
public class Pen {
    public String color;
    public int length;
    
    public void setPen(String a, int b){
        this.color = a;
        this.length = b;
    }
    
    public void getPen(){
        System.out.println(this.color);
        System.out.println(this.length);
    }    
}
