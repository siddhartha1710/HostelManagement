/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Siddhartha
 */
public class MyLogin {
    
    private String Id;
    private String password;
   
    public MyLogin(String Id, String password)
    {
        this.Id=Id;
        this.password=password;
    }
    
    public String getId()
    {
        return Id;
    }
    
    public String getPassword()
    {
        return password;
    }
}
