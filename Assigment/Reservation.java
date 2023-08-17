public abstract class Reservation
{
    private String name;
    private String Ic;
    private int adult;
    private int children;
    private String destination;
    private boolean way;
    private double Belgium=1020.00;
    private double Korea=835.00;
    private double Spain=1200.00;
    private double Japan=910.00;
    private double England=1520.00;
    
    public Reservation()
    {
        name="";
        Ic="";
        adult=0;
        children=0;
        destination="";
        way=true;
    }
    public Reservation(String n,String ic,int ad,int child,String d,boolean w)
    {
        name=n;
        Ic=ic;
        adult=ad;
        children=child;
        destination=d;
        way=w;
    }
    public void setReservation(String n,String ic,int ad,int child,String d,boolean w)
    {
        name=n;
        Ic=ic;
        adult=ad;
        children=child;
        destination=d;
        way=w;
    }
    String getName(){return name;}
    String getIC(){return Ic;}
    int getAdult(){return adult;}
    int getChildren(){return children;}
    String getDestination(){return destination;}
    boolean getWay(){return way;}
    
    public String toString()
    {
        return("\n Name :"+name+"\n Identity card :"+Ic+"\n Number of adult :"+adult+"\n Number of children :"+children+"\n Destination :"+destination+"\n Two ways reservation :"+way);
    }
    public int calculateTicket()
    {
        int ticket=0;
        ticket=getAdult()+getChildren();
        return ticket;
    }
    public double calculatePrice()
    {
        double price=0.00;
        if(destination.equalsIgnoreCase("belgium"))
        {
            price=(adult*Belgium)+((children*Belgium)*0.8);
        }
        else if(destination.equalsIgnoreCase("korea"))
        {
            price=(adult*Korea)+((children*Korea)*0.8);
        }
        else if(destination.equalsIgnoreCase("japan"))
        {
            price=(adult*Japan)+((children*Japan)*0.8);
        }
        else if(destination.equalsIgnoreCase("spain"))
        {
            price=(adult*Spain)+((children*Spain)*0.8);
        }
        else if(destination.equalsIgnoreCase("england"))
        {
            price=(adult*England)+((children*England)*0.8);
        }
        return price;
    }
    public double calculateWay()
    {
        double priceW=0.00;
        
        if(getWay()==true)
        {
            priceW=calculatePrice()*2;
        }
        else if(getWay()==false)
        {
            priceW=calculatePrice();
        }
        return priceW;
    }
    public abstract double calculateTotalPrice();
    public abstract double discountPrice();
}