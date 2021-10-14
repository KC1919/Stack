
import java.util.Stack;
public class Leet_739 
{
    public int[] dailyTemperatures(int[] temp)  //O(n) space complexity
    {
        int n = temp.length;
        int wait[] = new int[n];

        Stack<Integer> st = new Stack<>();

        st.push(n - 1);

        wait[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) 
        {
            while(st.size()>0 && temp[st.peek()]<=temp[i])
            {
            st.pop();
            }
            if(st.size()==0)
            wait[i]=0;

            else
            {
            wait[i]=st.peek()-i;
            }

            st.push(i);
        }

        return wait;
    }


    public int[] dailyTemp(int[] temp)   //space optimized O(1) space complexity
    {
        int n=temp.length;
        int wait[]=new int[n];
        
        wait[n-1]=0;
        
        for(int i=n-2;i>=0;i--)
        {
            
            if(temp[i]<temp[i+1])
                wait[i]=1;
            
            else
            {
                int j=i+1;
                
                while(j<n)
                {
                    if(temp[i]>=temp[j])
                    {
                        if(wait[j]==0)
                        {
                            wait[i]=0;
                            break;
                        }
                        else  
                            j+=wait[j];
                    }
                    else
                    {
                        wait[i]=j-i;
                        break;
                    }
                }
            }
        }
        
        return wait;
    }
}
