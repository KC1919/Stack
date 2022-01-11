/*
Given elements of a stack, clone the stack without using extra space.


Example 1:

Input:
N = 10
st[] = {1, 1, 2, 2, 3, 4, 5, 5, 6, 7}
Output:
1 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function clonestack() which takes the input stack st[], an empty stack cloned[], you have to clone the stack st into stack cloned.
The driver code itself prints 1 in the output if the stack st is cloned properly and prints 0 otherwise.


Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(1)
 */

import java.util.Stack;
class stackClone
{
    void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        
        while(st.size()>0)
        {
            int ele=st.pop();
            if(cloned.size()==0)
            cloned.push(ele);
            
            else
            {
                int count=0;
                while(cloned.size()>0)
                {
                    st.push(cloned.pop());
                    count++;
                }
                cloned.push(ele);
                
                while(count-->0)
                {
                    cloned.push(st.pop());
                }
            }
        }
        
    }
}