package HomeworkQuestions3B;

import java.util.Scanner;



/*  Class Node  */
class obj  {
	protected int dataLength;
    protected String data;
    protected obj next, prev;

    /* Constructor */
    public obj()     {
        next = null;
        prev = null;
        data = "";
        dataLength=data.length();
    }
    /* Constructor */
    public obj(String d, obj n, obj p)    {
        data = d;
        next = n;
        prev = p;
    }
    /* Function to set link to next node */
    public void setLinkNext(obj n)    {
        next = n;
    }
    /* Function to set link to previous node */
    public void setLinkPrev(obj p)    {
        prev = p;
    }
    /* Funtion to get link to next node */
    public obj getLinkNext()    {
        return next;
    }
    /* Function to get link to previous node */
    public obj getLinkPrev()    {
        return prev;
    }
    /* Function to set data to node */
    public void setData(String d)    {
        data = d;
    }
    /* Function to get data from node */
    public String getData()    {
        return data;
    }
}


 /************************************** Class LinkedList **************************************************/
class LinkedList {
    protected obj start;
    protected obj end ;
    public int size;

    /* Constructor */
    public LinkedList()    {
        start = null;
        end = null;
        size = 0;
    }
    /* Function to check if list is empty */
    public boolean isEmpty()     {
        return start == null;
    }
    /* Function to get size of list */
    public int getSize()     {
        return size;
    }
    /* Function to insert element at begining */
    public void insertAtStart(String Obj)    {
        obj nptr = new obj(Obj, null, null);
        if(start == null)         {
            start = nptr;
            end = start;
        }
        else         {
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        } 
        size++;
    }
    /* Function to insert element at end */
    public void insertAtEnd(String val)    {
        obj nptr = new obj(val, null, null);
        if(start == null)        {
            start = nptr;
            end = start;
        }
        else        {
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            end = nptr;
        }
        size++;
    }
    /* Function to insert element at position */
    public void insertAtPos(String obj , int pos)    {
    	obj nptr = new obj(obj, null, null);
        if (pos == 1)        {
            insertAtStart(obj);
            return;
        }
        obj ptr = start;
        for (int i = 2; i <= size; i++)        {
            if (i == pos)            {
            	obj tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(tmp);
                tmp.setLinkPrev(nptr);
            }
            ptr = ptr.getLinkNext();
        }
        size++ ;
    }
    /* Function to delete node at position */
    public void deleteAtPos(int pos)    {
        if (pos == 1)        {
            if (size == 1)            {
                start = null;
                end = null;
                size = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--;
            return ;
        }
        if (pos == size)        {
            end = end.getLinkPrev();
            end.setLinkNext(null);
            size-- ;
        }
        obj ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++)        {
            if (i == pos)            {
            	obj p = ptr.getLinkPrev();
            	obj n = ptr.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size-- ;
                return;
            }
            ptr = ptr.getLinkNext();
        }
    }
    /* Function to display status of list */
    public void display()    {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0)        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == null)        {
            System.out.println(start.getData() );
            return;
        }
        obj ptr = start;
        System.out.print(start.getData()+ " <-> ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null)        {
            System.out.print(ptr.getData()+ " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}


public class StockObjectList1 {
	

}
