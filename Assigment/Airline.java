import javax.swing.*;
import java.util.*;
import java.io.*;
public class Airline
{
    public static void main(String[] args)
    {
        try
        {
            File in=new File("destination.txt");
            FileReader fr=new FileReader(in);
            BufferedReader br=new BufferedReader(fr);
            
            File out=new File("memberReceipt.txt");
            FileWriter fw=new FileWriter(out);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            
            File ou=new File("nonmemberReceipt.txt");
            FileWriter fwr=new FileWriter(ou);
            BufferedWriter bwr=new BufferedWriter(fwr);
            PrintWriter pwr=new PrintWriter(bwr);
            
            File o=new File("customerList.txt");
            FileWriter f=new FileWriter(o);
            BufferedWriter b=new BufferedWriter(f);
            PrintWriter p=new PrintWriter(b);
            
            int w=0,q=0;
            int tot=0;
            int t=1;
            String a="";
            String l="";
            String input=br.readLine();
            while(input!=null)
            {
                StringTokenizer st=new StringTokenizer(input,",");
                String s1=st.nextToken(); 
                String d=s1;
                String s2=st.nextToken();
                double n1=Double.parseDouble(s2);
                String s3=st.nextToken();
                double n2=Double.parseDouble(s3);
                String s4=st.nextToken();
                double n3=Double.parseDouble(s4);
                
                a+=("\nDestination  "+(t++)+":"+d+"\nPrice per ticket for adult :"+n1+"\nPrice per ticket for children :"+n2+"\nFlight duration :"+n3+"\n");
           
                
                input=br.readLine();
            }
             int e=Integer.parseInt(JOptionPane.showInputDialog("How many customer do you want to enter?"));
                Reservation[] r=new Reservation[e];
            int next=0;
           do{
                
           int next1=Integer.parseInt(JOptionPane.showInputDialog("\n[1.Display menu]"+"\n[2.Buy flight ticket]"+"\n[3.Total customer]"+"\n[4.Max price]"
                +"\n[5.Minimum price]"+"\n[6.Average]"+"\n[7.Search customer]"+"\n[8.Exit]"+"\nEnter number :"));
            
           if(next1==1)
           {
            JOptionPane.showMessageDialog(null,"----------------.....WELCOME TO BLA BLA BLA FLIGHT AIRLINE.....---------------"+
            "\n --------------------------------: FLIGHT MENU :------------------------------"+a);
           }
                
           else if(next1==2)
           {
           
            
            for(int i=0;i<r.length;i++)
            {
                String name=JOptionPane.showInputDialog("Enter customer "+(i+1)+" name :");
                String Ic=JOptionPane.showInputDialog("Enter your identity card number:");
                int adult=Integer.parseInt(JOptionPane.showInputDialog("How many adults? :"));
                int children=Integer.parseInt(JOptionPane.showInputDialog("How many children? :"));
                String destination=JOptionPane.showInputDialog("Enter your destination :");
                boolean way=Boolean.parseBoolean(JOptionPane.showInputDialog("(true:two ways ticket)  (false:one way ticket) :"));
                boolean member=Boolean.parseBoolean(JOptionPane.showInputDialog("Are you a member ?(true/false) :"));
                
                if(member==true)
                {
                    String MemberId=JOptionPane.showInputDialog("Enter your membership id :");
                    String MemberType=JOptionPane.showInputDialog("Enter your membership type :");
                    
                    r[i]=new Member(name,Ic,adult,children,destination,way,MemberId,MemberType);
                }
                else if(member==false)
                {
                    boolean coupon=Boolean.parseBoolean(JOptionPane.showInputDialog("Any coupon to include ?(true or false) :"));
                    
                    r[i]=new NonMember(name,Ic,adult,children,destination,way,coupon);
                    
                    
                    
                }
            }
       
            pw.println("-----------------------___________________MEMBER RECEIPT____________________-----------------------");
            pwr.println("---------------------______________________NON-MEMBER RECEIPT__________________-----------------------");
            
            for(int i=0;i<r.length;i++)
            { 
                
                if(r[i] instanceof Member)
                { 
                  
                    pw.println(r[i].toString());
                   
                }
                if(r[i] instanceof NonMember)
                {
                   
                    pwr.println(r[i].toString());
                }
            }
       
            p.println("+--------------------------List of customer name and IC------------------------------+");
            for(int i=0;i<r.length;i++)
            {
                tot++;
                p.println("\nCustomer name :"+r[i].getName()+"\nCustomer IC :"+r[i].getIC());
            }
           }
    
                else if(next1==7)
                { 
                    
                           
                             String search=JOptionPane.showInputDialog("Enter name to be search :");
                             int position=0;
                             boolean found=false;
                             for(int i=0 ; i < r.length; i++){
                                if (r[i].getName().equals(search))
                                {
                                     found = true;
                                     position=i;
                                }
                                
                          }
                          if(found)
                                {
                                    JOptionPane.showMessageDialog(null,"Customer name found"+"\n Customer info .."+"\n"+r[position].toString());
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Customer name not found");
                        
                                }
                        }
                    
                    
                
                else if(next1==3)
                {
                    int tic=0;
                    for(int i=0;i<r.length;i++)
                    {
                        tic+=r[i].calculateTicket();
                    }
                    JOptionPane.showMessageDialog(null,"1.FIND TOTAL CUSTOMER ......."+"\n"+"\n"+"\nTotal customer of this airline is "+tot+"\nTotal ticket sold is "+tic);
                }
                else if (next1==4)
                {
                        double max=0.00;
                        max=r[0].calculateTotalPrice();
                        for(int i=0;i<r.length;i++){
                            
                            if (r[i].calculateTotalPrice()>max)
                            {
                                q=i;
                                max=r[i].calculateTotalPrice();
                            }
                        }
                        
                        
                        JOptionPane.showMessageDialog(null,"2.FIND MAXIMUM PRICE ......."+"\n"+"\n"+"\nThe highest payment is RM "+ max+"\nFrom customer :"+r[q].getName());
                }
                else if(next1==5)
                {
                        double min=0.00;
                        min=r[0].calculateTotalPrice();
                       
                        for(int i=0;i<r.length;i++){
                            
                            
                            if (r[i].calculateTotalPrice()<min)
                            {
                                w=i;
                                min=r[i].calculateTotalPrice();
                               
                            }
                        }
                        
                        JOptionPane.showMessageDialog(null,"3.FIND MINIMUM PRICE ......."+"\n"+"\n"+"\nThe lowest payment is RM"+ min+"\nFrom customer :"+r[w].getName());
                }
                else if(next1==6)
                {
                   
                        double ave=0.0,total=0.0;
                        
                        for (int i=0;i<r.length;i++)
                        {
                            total+= r[i].calculateTotalPrice();
                        }
                        
                        ave=total/r.length;
                        
                        JOptionPane.showMessageDialog(null,"4.FIND AVERAGE......."+"\n"+"\n"+"\nAverage total price is RM "+ave);
                }
                else if (next1==8)
                {
                    next=8;
                }
      
          br.close();
          pwr.close();
          pw.close();
          p.close();
        }while(next != 8);
          
        
            if(next ==8)
            {
              JOptionPane.showMessageDialog(null," System will exit now...");
            }
            JOptionPane.showMessageDialog(null,"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~THANK YOU FOR CHOOSING THIS AIRLINE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+"\n"+"\n"+"\n"+
            "------------------------------------              HAVE A NICE DAY !            --------------------------------------");
        
      
        }
        catch (FileNotFoundException e)
           {System.out.println("Problem :"+e.getMessage());}
           catch(IOException ioe)
           {System.out.println("Problem : " + ioe.getMessage());}
        
    }  
}
            
         
    
            
        
          
        
     
    

    


