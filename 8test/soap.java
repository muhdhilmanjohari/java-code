import java.io.*;

public class soap extends Object
{
   
    private String brand;
    private String pCode;
    private String pName;
    private double pPrice;
    private char ptype;

    //default contructor
    public soap()
    {
        brand = " ";
        pCode = " ";
        pName = " ";
        pPrice = 0;
        ptype =' ';
        
    }

    
    public soap(String b, String pC, String pN, double pP, char pt) 
    {
        this.brand = b;
        this.pCode = pC;
        this.pName = pN;
        this.pPrice = pP;
        this.ptype = pt;
    }
    
    public soap(soap obj)
    {
        brand = obj.brand;
        pCode = obj.pCode;
        pName = obj.pName;
        pPrice = obj.pPrice;
        ptype = obj.ptype;
    }
    
    public void setSoap(String brand, String pCode, String pName, double pPrice, char ptype)
    {
        this.brand = brand;
        this.pCode = pCode;
        this.pName = pName;
        this.pPrice = pPrice;
        this.ptype = ptype;
    }
    
    public void setBrand(String brand){this.brand = brand;}
    public void setpCope(String pCode){this.pCode = pCode;}
    public void setpName(String pName){this.pName = pName;}
    public void setpPrice(double pPrice){this.pPrice = pPrice;}
    public void setptype(char ptype){this.ptype = ptype;}
    
    public String getBrand()
    {
        return brand;
    }
    
    public String getpCode()
    {
       return pCode;
    }
    
    public String getpName()
    {
        return pName;
    }
    
    public double getpPrice()
    {
        return pPrice;
    }
    
    public double getptype()
    {
        return ptype;
    }
    
    public String toString()
    {
        String Soap = "\nProduct Brand : "+brand+"\nProduct Code : "+pCode+"\nProduct Name : "+pName+
                        "\nProduct Price : " +pPrice+ "\nProduct Type : " +ptype;
                        
        return Soap;
    }
    
    
    
    
}
