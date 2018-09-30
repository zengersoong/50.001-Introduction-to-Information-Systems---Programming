package DataStructures.liblinkedlists;
import java.util.*;

class SinglyLinkedListStack
{
    protected Node top ;
    protected int size ;
 

    public SinglyLinkedListStack()
    {
        top = null;
        size = 0;
    }    
    public boolean isEmpty()
    {
        return top == null;
    }    
    public int getSize()
    {
        return size;
    }    
    public void push(int data)
    {
        Node nptr = new Node (data, null);
        if (top == null)
            top = nptr;
        else
        {
            nptr.setLink(top);
            top = nptr;
        }
        size++ ;
    }    
    public int pop()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        Node ptr = top;
        top = ptr.getLink();
        size-- ;
        return ptr.getData();
    }    
    public int peek()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        return top.getData();
    }    
    public void displayStack()
    {
        System.out.print("\nStack = ");
        if (size == 0) 
        {
            System.out.print("Empty\n");
            return ;
        }
        Node ptr = top;
        while (ptr != null)
        {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getLink();
        }
        System.out.println();        
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);   
        /* Creating object of class linkedStack */   
        SinglyLinkedListStack ls = new SinglyLinkedListStack();          
        /* Perform Stack Operations */  
        System.out.println("Linked Stack Test\n");  
        char ch;     
        do 
        {
            System.out.println("\nLinked Stack Operations");
            System.out.println("1. Push");
            System.out.println("2. Top");
            System.out.println("3. pop");
            System.out.println("4. isEmpty");
            System.out.println("5. displayStack");            
            int choice = scan.nextInt();
            switch (choice) 
            {
            case 1 :
                System.out.println("Enter integer element to push");
                ls.push( scan.nextInt() ); 
                break;                         
            case 2 : 
                try
                {
                    System.out.println("Peek Element = "+ ls.peek());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;
            case 3 : 
                try
                {
                    System.out.println("Popped Element = "+ ls.pop());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }    
                break;                         
                                     
            case 4 : 
                System.out.println("Empty status = "+ ls.isEmpty());
                break;                
                            
            case 5 : 
                System.out.println("Stack = "); 
                ls.displayStack();
                break;                        
            default : 
                System.out.println("Wrong Entry \n ");
                break;
            }            
            ls.displayStack();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);       
 
        } while (ch == 'Y'|| ch == 'y');                 
    }
}
 
