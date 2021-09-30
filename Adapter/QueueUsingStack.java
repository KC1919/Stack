package Adapter;
import java.util.*;

public class QueueUsingStack {
    private Stack<Integer>st;
    private Stack<Integer>ts;
    
    public QueueUsingStack() 
    {
        st=new Stack<>();
        ts=new Stack<>();
    }
    
    public void push(int x) 
    {
        st.push(x);
    }
    
    public int pop() 
    {
        
        swap(st,ts);
        
        int remEle=ts.pop();
        
        swap(ts,st);
        
        return remEle;
    }
    
    public void swap(Stack<Integer>s1, Stack<Integer>temp)
    {
        while(s1.size()!=0)
        {
            temp.push(s1.pop());
        }
    }
    
    public int peek() 
    {
        swap(st,ts);
        int peek=ts.peek();
        swap(ts,st);
        return peek;
    }
    
    public boolean empty() 
    {
        return st.size()>0?false:true;
    }

    public static void main(String args[])
    {
        QueueUsingStack obj=new QueueUsingStack();
    }
}
