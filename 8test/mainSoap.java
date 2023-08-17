import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;
public class mainSoap
{
    public static void main (String[]args)
    {
        Scanner in = new Scanner(System.in);
        
        //decalre linked list, stack and queue
        LinkedList soapList = new LinkedList();
        Queue soapQue = new Queue();
        Queue tempQ = new Queue();
        Stack soapStack = new Stack();
        Stack tempStack = new Stack();
        
        
        String brand,pCode,pName;
        double pPrice;
        char ptype;
        soap s;
        
        char next = 'y';
        Scanner sc = new Scanner(System.in);
 
      System.out.println("Soap enterprise Database");
      System.out.println("\nAction Number menu: ");
      System.out.println("\n1: Add item(s) \n2: Display item \n3: Delete item \n4: Search item "); 
      System.out.println("5: Move Men soap to iQueue soap \n6: Total and average of soap price");
      System.out.println("7: Highest and lowest price \n8: Infix to Postfix");
      
      while (next == 'y' || next == 'Y')
      {
         System.out.println("\nPlease enter action number (1/2/3/4/5/6/7/8)");
         int opt = sc.nextInt();
         
         //Add item(s) 
         if (opt == 1)
         {
            System.out.print("\nPlease enter the number of soap(s): ");
            int size = sc.nextInt();
            
            for (int index = 0; index<size; index++)
            {
               System.out.print("\nPlease enter soap brand: ");
               brand = sc.next();
               System.out.print("\nPlease enter soap code : ");
               pCode = sc.next();
               System.out.print("\nPlease enter soap name ");
               pName = sc.next();
               System.out.print("\nPlease enter soap price: ");
               pPrice = sc.nextDouble();
               System.out.print("\nPlease enter soap type Men=m/Women=w: ");
               ptype = sc.next().charAt(0);
               sc.nextLine();
               s = new soap(brand, pCode, pName, pPrice, ptype);

               //Add to ArrayList
               soapList.insertAtBack(s);
               soapQue.enqueue(s);
               soapStack.push(s);
            }

            System.out.print("\nDo you like to make another action? (Y- Yes/N- No): ");
            next = sc.next().charAt(0);
         }
         
         //Display all data 
         else if (opt == 2)
         {
            System.out.println("\nSoap Data");
            soap s1;
            while(!soapQue.isEmpty())
            {
                s1 = (soap) soapQue.dequeue();
                System.out.println(s1);
                tempQ.enqueue(s1);
            }
         
            while(!tempQ.isEmpty())
            {
               soapQue.enqueue(tempQ.dequeue());
            }

            
            System.out.print("\nDo you like to make another action? (Y- Yes/N- No): ");
            next = sc.next().charAt(0);
         }
         
         //Delete item(s)
         else if (opt == 3)
         {
            System.out.println("\nPlease enter the soap code that you want to delete: ");
            String delete = sc.next();
        
            Stack newList = new Stack();
            while(!soapStack.isEmpty())
            {
                soap s2 = (soap) soapStack.pop();
                if(s2.getpCode().equalsIgnoreCase(delete))
                {
                    newList.push(s2);
                }
                
                else
                {
                    tempStack.push(s2);
                }
            }
            
            while(!tempStack.isEmpty())
            {
                 soapStack.push(tempStack.pop());
            }
            
            
            System.out.println("\nSoap Data");
            soap s3;
            while(!soapStack.isEmpty())
            {
                s3 = (soap) soapStack.pop();
                System.out.println(s3);
                tempStack.push(s3);
            }
        
            while(!tempStack.isEmpty())
            {
                soapStack.push(tempStack.pop());
            }
            
            System.out.print("\nDo you like to make another action? (Y- Yes/N- No): ");
            next = sc.next().charAt(0);
         }
         
         //Search item
         else if (opt == 4)
         {
            String search;
            System.out.println("\nPlease enter soap code that you want to search: ");
            search = sc.next();
        
            boolean found = false;
            soap s9 = new soap();
            while(!soapQue.isEmpty())
            {
                soap s8 = (soap) soapQue.dequeue();
                if(s8.getpCode().equalsIgnoreCase(search))
                {
                    found = true;
                    s9 = s8;
                }
                tempQ.enqueue(s8);
            }
            
            if(found)
            {
                System.out.println("\nSoap Details: " + s9.toString());
            }
            
            else
            {
                System.out.println("\nSoap is not in the list");
            }
            
            System.out.print("\nDo you like to make another action? (Y- Yes/N- No): ");
            next = sc.next().charAt(0);
         }
         
         //Move all men soap into IQueue
         else if (opt == 5)
         {
            Queue IQueue = new Queue();
            soap s4;
            while(!soapQue.isEmpty())
            {
                s4 = (soap) soapQue.dequeue();
                if(s4.getptype() == 'm' || s4.getptype() == 'M')
                { 
                   IQueue.enqueue(s4);
                }
            
                else
                {
                   tempQ.enqueue(s4);
                }
            }
        
            while(!tempQ.isEmpty())
            {
               soapQue.enqueue(tempQ.dequeue());
            }
            
            System.out.println("\nSoap Data in IQueue");
            soap s5;
            while(!IQueue.isEmpty())
            {
                s5 = (soap) IQueue.dequeue();
                System.out.println(s5);
                tempQ.enqueue(s5);
            }
         
            while(!tempQ.isEmpty())
            {
               soapQue.enqueue(tempQ.dequeue());
            }
            
            System.out.print("\nDo you like to make another action? (Y- Yes/N- No): ");
            next = sc.next().charAt(0);
        }
         
         //Sum and average item
         else if (opt == 6)
         {
              double price = 0.0, total = 0.0, average = 0; 
              int quantity = 0;
              soap s6;
              int c6 = 0;
              
              while(!soapQue.isEmpty())
              {
                s6 = (soap) soapQue.dequeue();
                
                c6++;
                
                price = s6.getpPrice();
                total = total + price;
              }
              average=total/c6;
              
              System.out.println("Total soap price is RM" + total);
              System.out.println("\nAverage price for soap is RM" + average);
              
              while(!tempQ.isEmpty())
              {
                soapQue.enqueue(tempQ.dequeue());
              }

              System.out.print("\nDo you like to make another action? (Y- Yes/N- No): ");
              next = sc.next().charAt(0);
         }
         
         //Min and Max
         else if (opt == 7)
         {
              double low = 1000000, high = 0;
              soap s7, s8;
              
              while(!soapStack.isEmpty())
              {
                 s7 = (soap) soapStack.pop();
                 if(low > s7.getpPrice())
                 {
                    low = s7.getpPrice();
                 }
                 
                 if(high < s7.getpPrice())
                 {
                    high = s7.getpPrice();
                 }
                 
                 tempQ.enqueue(s7);
              }
              
              while(!tempStack.isEmpty())
              {
                 soapStack.push(tempStack.pop());
              }
              
              System.out.println("The lowest price is RM" + low  );
              System.out.println("\nThe highest price is RM" + high );

              System.out.print("\nDo you like to make another action? (Y- Yes/N- No): ");
              next = sc.next().charAt(0);
         }
         
          else if (opt == 8)
          {
              String input, output;
              System.out.println("\nExpression conversion (Infix To Postfix)");
              System.out.println("\nPlease enter the infix expression: ");
              input = sc.next();
              Intopost theConvert = new Intopost(input);
              output = theConvert.convert();
              System.out.println("\nPostfix expression: " + output);
              
              System.out.print("\nDo you like to make another action? (Y- Yes/N- No): ");
              next = sc.next().charAt(0);
          }
      }
   
        
                
            
        
        
    }
}
