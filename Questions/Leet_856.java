/*
856. Score of Parentheses

Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2
Example 4:

Input: s = "(()(()))"
Output: 6
 */

import java.util.Stack;
public class Leet_856 
{
    public int scoreOfParentheses(String s) 
    {
        Stack<String>st=new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            if(ch=='(')
            {
                st.push("(");
            }
            
            else if(ch==')')
            {
                if(st.size()>0)
                {
                    int sum=0;
                    
                    if(!st.peek().equals("("))
                    {
                        while(st.size()>0 && !st.peek().equals("("))
                        {
                            sum+=Integer.parseInt(st.pop());
                        }
                        if(st.size()==0)
                            st.push(sum+"");

                        else
                        {
                            st.pop();
                            st.push((2*sum)+"");
                        }
                    }
                    else
                    {
                        st.pop();
                        st.push(1+"");
                    }
                }
            }
        }   
        
        int res=0;
        
        while(st.size()!=0)
        {
            res+=Integer.parseInt(st.pop());
        }
        
        return res;
        
    }
}
