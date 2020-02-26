/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siaja;

/**
 *
 * @author juanr
 */
public class Customer {
    
    private String fName;
    private String lName;
    private String phone;
    private int id;
    
    public Customer()
    {
        this.fName="";
        this.lName="";
        this.phone="";
        this.id=0;
    }
    
    public Customer(String fName, String lName, String phone,int id)
    {
        this.fName=fName;
        this.lName=lName;
        this.phone=phone;
        this.id=id;
    }
    
    public void setfName(String fName){
        this.fName=fName;
    }
    
    public String getfName(){
        return fName;
    }
    
    public void setlName(String lName){
        this.lName=lName;
    }
    
    public String getlName(){
        return lName;
    }
    
    public void setphone(String phone){
        this.phone=phone;
    }
    
    public String getphone(){
        return phone;
    }
    
    public void setid(int id){
        this.id=id;
    }
    
    public int getid(){
        return id;
    }
    
    
    
}
