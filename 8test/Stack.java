public class Stack extends LinkedList
{
    public Stack() // default constructor
    {
        super();
    }
    
    public void push(Object item) // insert item onto stack
    {
       insertAtFront(item);
    }
    
    public Object pop() // remove item from stack
    {
       return removeFromFront();
    }
    
    public Object top() // retrieve the top item
    {
        return getFirst();
    }
    
    public boolean empty() // check whether the stcak is empty
    {
       return isEmpty();  
    }
    
     // display the contents of list
    public void print()
    {
        super.display();
    }
    
  }