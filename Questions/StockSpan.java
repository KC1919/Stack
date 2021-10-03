package Questions;

import java.util.Stack;
public class StockSpan {
    public static int[] calculateSpan(int price[], int n)
    {
        int res[]=new int[n];
        
        Stack<Integer>st=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            if(st.size()==0)
            {
                st.push(i);
                res[i]=1;
            }
            else
            {
                if(price[i]<price[st.peek()])
                {
                    st.push(i);
                    res[i]=1;
                }
                else
                {
                    while(st.size()!=0 && price[st.peek()]<=price[i])
                    {
                        st.pop();
                    }
                    
                    if(st.size()==0)
                    res[i]=i+1;
                    
                    else
                    res[i]=i-st.peek();
                    
                    st.push(i);
                }
            }
        }
        return res;
    }
}
