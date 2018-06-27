/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_operation_08;
import java.sql.Date;
import java.util.HashMap;
/**
 *
 * @author sumi3
 */
public class Profiles {
    
    private HashMap<String, String> data;
    
    public Profiles(){
        this.data = new HashMap<String, String>();
    }
    
    public String getData(String a){
        return data.get(a);
    }
    public void setData(String a, String b){
        data.put(a, b);
    }
}
