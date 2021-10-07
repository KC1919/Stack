package Questions;

import java.util.Stack;
public class Valid_Stack_Sequence {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) 
    {
        Stack<Integer>st=new Stack<>();
        int idx=0;
    
        for(int i=0;i<pushed.length;i++)
        {
            if(pushed[i]!=popped[idx])
            {
                while(st.size()!=0 && st.peek()==popped[idx] && idx<popped.length)
                {
                    st.pop();
                    idx++;
                }
                st.push(pushed[i]);
            }
            else
                idx++;
        }
        while(st.size()!=0 && idx<popped.length)
        {
            if(st.peek()==popped[idx])
            {
                st.pop();
                idx++;
            }
            else
            {
                return false;
            }
        }
        
        return st.size()==0?true:false;
    }
}
