

import java.util.Stack;
class Leet_77
{
    public String simplifyPath(String s) 
    {
        if(s.length()==0)
            return "";
        
        Stack<String>st=new Stack<>(); //we first put a slash in the stack, as it is the beginning of every path
        st.push("/");
        
        String path[]=s.split("/"); //split the path with respect to the slashes
        
        // if the given path is = "/a/..../abcd/../../c/..../"
        //so after splitting    = ["", "a", "....", "abcd", "..", "..", "c", "...."]
        
        for(int i=0;i<path.length;i++)  //iterate on the path
        {
            String ch=path[i]; //take out an element of the path
            
            if(ch.equals(""))  //if we get a space as an element, we simply move to the next element
                continue;
            
            else if(ch.charAt(0)=='.')  //if the element starts with a "."
            {
                if(ch.length()>2)  //then if its length is greater than 2 , it means its a file name
                {
                    st.push(ch);   //so we push it into the stack
                    st.push("/");  //and add a slash after it, since we had removed earlier all the slashes
                    continue;      //so we have to put after each push operation a slash, which marks the end to that route at that file name
                }
                else if(ch.length()==2) //if the length is equal to 2
                {
                    while(st.size()>0 && st.peek().equals("/"))  //then we start popping elements("/") from the stack, till we get to a file name
                    {
                        st.pop();  //as ".." means move to the parent path, so we have to go back, so we pop from the stack
                    }
                    if(st.size()>0)  //we see if the size has not become 0
                        st.pop();    //we pop the top element, as we would be still standing at current filename, since we only popped slashes
                                    //and as we have to move to previous file name , so we pop the current
                }
                if(st.size()!=0 && st.peek().equals("/")) //then we check if the size is still not 0, and the peek is a slash, we continue
                    continue;
                else
                    st.push("/");
                
            }
            else   //if the element is not a "/" not a "." measn its a file name, and we simply push it onto the stack and also push a slash after it
            {
                st.push(ch);
                st.push("/");
            }
        }
        
        if(st.size()>1 && (st.peek().equals("/") || st.peek().equals(".")))
            st.pop();
        
        if(st.size()==0)  //if the stack size has become 0 , we push a slash, as empty file path is not valid
            st.push("/");
        
        StringBuilder sb=new StringBuilder();  //we make a string builder
        
        while(st.size()>0)  //start popping the elements and appending to the front of the stringBuilder as the stack will give the reverse order of the path
        {
            sb.insert(0,st.pop());
        }
        
        return sb.toString();  //finally convert the sb to string and return
    }
}