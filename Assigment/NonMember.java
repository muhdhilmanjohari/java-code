public class NonMember extends Reservation
{
    private boolean coupon;
    
    public NonMember()
    {
        super();
        coupon=true;
    }
    public NonMember(String n,String ic,int ad,int child,String d,boolean w,boolean c)
    {
        super(n,ic,ad,child,d,w);
        coupon=c;
    }
    public void setNonMember(String n,String ic,int ad,int child,String d,boolean w,boolean c)
    {
        super.setReservation(n,ic,ad,child,d,w);
        coupon=c;
    }
    boolean getCoupon(){return coupon;}
    
    public String toString()
    {
        return(super.toString()+"\n Include coupon :"+coupon+"\nPrice before discount :"+super.calculateWay()+
        "\nDiscount percent : "+discountPrice()+"\nTotal price to pay :"+calculateTotalPrice());
    }
    
    public double discountPrice()
    {
        double dp=0.00;
        
        if(getCoupon()==true)
        {
            dp=0.95;
        }
        else if(getCoupon()==false)
        {
            dp=1.00;
        }
        return dp;
    }
    public double calculateTotalPrice()
    {
        double tPrice=0.00;
        
        tPrice=super.calculatePrice()*discountPrice();
        
        return tPrice;
    }
}
    