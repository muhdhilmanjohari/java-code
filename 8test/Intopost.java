public class Intopost
{
    private StackExpression inStack;
    private String input;
    private String output = "";

    public Intopost(String in)
    {
        input = in;
        int stackSize = input.length();
        inStack = new StackExpression(stackSize);
    }

    public String convert()
    {
        for(int x = 0; x < input.length(); x++)
        {
            char ch = input.charAt(x);
            switch(ch)
            {
                case '+':
                case '-':
                    getOperation(ch,1);
                    break;
                case '*':
                case '/':
                    getOperation(ch,2);
                    break;
                case '(':
                    inStack.push(ch);
                    break;
                case ')':
                    getParent(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        
        while(!inStack.isEmpty())
        {
            output = output + inStack.pop();
        }
        return output;
    }
    
    public void getOperation(char opThis, int prec1)
    {
        while(!inStack.isEmpty())
        {
            char opTop = inStack.pop();
            if(opTop == '(')
            {
                inStack.push(opTop);
                break;
            }
            else
            {
                int prec2;
                if(opTop == '+' || opTop == '-')
                {
                    prec2 = 1;
                }
                else
                {
                    prec2 = 2;
                }
                if(prec2 < prec1)
                {
                    inStack.push(opTop);
                    break;
                }
                else
                {
                    output = output + opTop;
                }
            }
        }
        inStack.push(opThis);
    }
    
    public void getParent(char ch)
    {
        while(!inStack.isEmpty())
        {
            char ch1 = inStack.pop();
            if(ch1 == '(')
            {
                break;
            }
            else
            {
                output = output + ch1;
            }
        }
    }
}
