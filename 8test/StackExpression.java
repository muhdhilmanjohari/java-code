
public class StackExpression
{
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackExpression(int max)
    {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char x)
    {
        stackArray[++top] = x;
    }
    
    public char pop()
    {
        return stackArray[top--];
    }
    
    public char peek()
    {
        return stackArray[top];
    }
    
    public boolean isEmpty()
    {
        return(top == -1);
    }
}
