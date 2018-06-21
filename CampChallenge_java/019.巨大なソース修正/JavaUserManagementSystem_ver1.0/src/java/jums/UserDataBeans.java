/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;
import java.io.Serializable;


/**
 *
 * @author sumi3
 */
public class UserDataBeans implements Serializable {
    private String name;
    private int year;
    private int month;
    private int day;
    private String tell;
    private int type;
    private String comment;
    
    public UserDataBeans(){}
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth(){    
        return month;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell) { 
        this.tell = tell;
    }
    public int getType() { 
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getComment() { 
        return comment;
    } 
    public void setComment(String comment) { 
        this.comment = comment;
    }
        
}
