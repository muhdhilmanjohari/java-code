
public class Queue extends LinkedList{
   //default constructor
   public Queue()
   {
        super();
   }
   
   //to insert an element at the end of the queue
   public void enqueue(Object obj){
      insertAtBack(obj);
   }
   
   //to remove an element at front of the queue
   public Object dequeue()
   {
      return removeFromFront();
   }
   
   //to get an element at the front of the queue
   public Object getFront(){
      return getFirst();
   }
   
   //to get an element at the end of the queue
   public Object getEnd(){
      Object obj = removeFromBack();
      insertAtBack(obj);
      return obj;
   }
}
