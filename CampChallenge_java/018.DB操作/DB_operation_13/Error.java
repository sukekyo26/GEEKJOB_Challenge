/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_operation_13;
import java.io.Serializable;

/**
 *
 * @author sumi3
 */
public class Error implements Serializable{
    private int count;
    public Error(int count){
        this.count = count;
    }
    public int getCount(){
        return count;
    }
    
}
