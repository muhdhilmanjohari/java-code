public class Member extends Reservation
{
    private String MemberId;
    private String MemberType;
    
    public Member()
    {
        super();
        MemberId="";
        MemberType="";
    }
    public Member(String n,String ic,int ad,int child,String d,boolean w,String mi,String mt)
    {
        super(n,ic,ad,child,d,w);
        MemberId=mi;
        MemberType=mt;
    }
    public void setMember(String n,String ic,int ad,int child,String d,boolean w,String mi,String mt)
    {
        super.setReservation(n,ic,ad,child,d,w);
        MemberId=mi;
        MemberType=mt;
    }
    String getMemberId(){return MemberId;}
    String getMemberType(){return MemberType;}
    
    public String toString()
    {
        return(super.toString()+"\n Member ID :"+MemberId+"\n Member type :"+MemberType+"\nPrice before discount :"+super.calculateWay()+
        "\nDiscount percent :"+discountPrice()+"\nTotal price to pay :"+calculateTotalPrice());
    }
    public double discountPrice()
    {
        double dp=0.00;
        if(MemberType.equalsIgnoreCase("diamond"))
        {
            dp=0.8;
        }
        else if(MemberType.equalsIgnoreCase("platinum"))
        {
            dp=0.85;
        }
        else if(MemberType.equalsIgnoreCase("gold"))
        {
            dp=0.9;
        }
        return dp;
    }
        
            
    public double calculateTotalPrice()
    {
        double tPrice=0.00;
        
        tPrice=super.calculateWay()*discountPrice();
        
        return tPrice;
    }
}
    