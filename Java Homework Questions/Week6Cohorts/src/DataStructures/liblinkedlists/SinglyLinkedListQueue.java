package DataStructures.liblinkedlists;

import java.util.NoSuchElementException;
import java.util.Scanner;

class SinglyLinkedListQueue
{
    protected Node front, back;
    public int size;
 

    public SinglyLinkedListQueue()
    {
        front = null;
        back = null;
        size = 0;
    }    
    
    public boolean isEmpty()
    {
        return front == null;
    }    
    
    public int getSize()
    {
        return size;
    }    
    
    public void insert(int data)
    {
        Node nptr = new Node(data, null);
        if (back == null)
        {
            front = nptr;
            back = nptr;
        }
        else
        {
            back.setLink(nptr);
            back = back.getLink();
        }
        size++ ;
    }    
    
    public int remove()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        Node ptr = front;
        front = ptr.getLink();        
        if (front == null)
            back = null;
        size-- ;        
        return ptr.getData();
    }    
    /*  Function to check the front element of the queue */
    public int peek()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return front.getData();
    }    
 
    public void displayQueue()
    {
        System.out.print("\nQueue = ");
        if (size == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        Node ptr = front;
        while (ptr != back.getLink() )
        {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getLink();
        }
        System.out.println();        
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); 
 
        SinglyLinkedListQueue lq = new SinglyLinkedListQueue();            
  
        System.out.println("Linked Queue Test\n"); 
        char ch;        
        do
        {
            System.out.println("\nQueue Operations");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. DisplayQueue");
            System.out.println("4. isEmpty");
            
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                lq.insert( scan.nextInt() );
                break;                         
            case 2 : 
                try 
                {
                    System.out.println("Removed Element = "+ lq.remove());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }    
                break;                         
            case 3 : 
                try
                {
                    System.out.println("Peek Element = "+ lq.peek());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                         
            case 4 : 
                System.out.println("Empty status = "+ lq.isEmpty());
                break;

            default : 
                System.out.println("Wrong Entry \n ");
                break;
            }                
            lq.displayQueue();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);            
        } while (ch == 'Y'|| ch == 'y');                                                            
    } 
}

  
    