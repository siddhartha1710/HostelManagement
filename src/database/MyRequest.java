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
public class MyRequest {
    
    private String Id;
    private String Name;
    private String RNum;
    private String Stdrequest;
    private String Date;
    
    public MyRequest(String Id, String Name, String RNum,String Stdrequest, String Date)
    {
        this.Id=Id;
        this.Name=Name;
        this.RNum=RNum;
        this.Stdrequest=Stdrequest;
        this.Date=Date;
    }
    
    public String getId()
    {
        return Id;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public String getRNum()
    {
        return RNum;
    }
    
    public String getStdrequest()
    {
        return Stdrequest;
    }
    
    public String getDate()
    {
        return Date;
    }
}
