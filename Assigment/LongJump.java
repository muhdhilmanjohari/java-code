

import java.util.*;
import javax.swing.*;
public class LongJump
{
    private String id;
    private String name;
    private String code;
    private double jump[];
    
    public LongJump(String i,String n,String c,double j)
    {
        id=i;
        name=n;
        code=c;
        jump[2]=j;
    }
    public void setLongJump(String i,String n,String c,double j)
    {
        id=i;
        name=n;
        code=c;
        jump[2]=j;
    }
    public String getID(){return id;}
    public String getName(){return name;}
    public String getCode(){return code;}
    public double getJump(){return jump[2];}
    
    public double calcAverage()
    {
        double a=0.00;
        
        a=(jump[1]+jump[2])/2;
        return a;
    }
    public String detStatus()
    {
        String status="";
        if(calcAverage()>=7.00){
            status="qualified";
        }
        else if(calcAverage()>=5.00 && calcAverage() <7.00){
            status="reserve";
        }
        else if(calcAverage()<5.00){
            status="disqualified";
        }
        return status;
    }
    public String toString()
    {
        return("id"+getID()+"\n name"+getName()+"\n code"+getCode()+"\n jump"+getJump()+"\n average"+calcAverage()+"\n status"+detStatus());
    }
    public void main(String[]args)
    {
        
        String id=JOptionPane.showInputDialog("enter id");
        String name=JOptionPane.showInputDialog("enter name");
        String code=JOptionPane.showInputDialog("enter code ");
        for(int i=0;i<2;i++)
        {
        double jump=Double.parseDouble(JOptionPane.showInputDialog("enter jump"));
        }
         x=new LongJump(id,name,code,jump[]);
        
    }
   
    

    
    
    
}
        
        
            
        
    
    
    