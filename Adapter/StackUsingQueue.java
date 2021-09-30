package Adapter;

import java.util.*;
public class StackUsingQueue {
    Queue<Integer>mq;
    Queue<Integer>tq;
    int size;
    
    public StackUsingQueue() 
    {
        mq=new LinkedList<>();
        tq=new LinkedList<>();
    }
    
    public void push(int x) 
    {
        mq.add(x);       
    }
    
    public int pop() 
    {
        if(mq.size()==1)
            return mq.remove();
        
        swap(mq,tq);
        int rem=mq.remove();
        swap(tq,mq);
        mq.add(tq.remove());
        return rem; 
    }
    
    public void swap(Queue<Integer>s1, Queue<Integer>temp)
    {
        while(s1.size()!=1)
        {
            temp.add(s1.remove());
        }
    }
    
    public int top() 
    {
        if(mq.size()==1)
            return mq.peek();
        
        swap(mq,tq);
        int rem=mq.remove();
        swap(tq,mq);
        mq.add(tq.remove());
        mq.add(rem);
        return rem; 
    }
    
    public boolean empty() 
    {
        return mq.size()>0?false:true;  
    }

    public static void main(String args[])
    {
        StackUsingQueue obj=new StackUsingQueue();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
