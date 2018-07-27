/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_operation_13;

/**
 *
 * @author sumi3
 */
public class User {
    private String name;
    private int password;
    
    public User(String name ,int pass){
        this.name = name;
        this.password = pass; 
    }
    public String getName() {
        return name;
    }
    public int getPassword() {
        return password;
    }
        
    
}
