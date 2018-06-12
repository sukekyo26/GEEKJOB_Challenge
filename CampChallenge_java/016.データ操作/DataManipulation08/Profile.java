/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManipulation08;

import java.io.Serializable;

/**
 *
 * @author sumi3
 */
public class Profile implements Serializable{
    private String name;
    private String gender;
    private String interest;
    
    public Profile(){}
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public String getInterest(){
        return interest;
    }
    public void setInterest(String interest){
        this.interest = interest;
    }    
}
