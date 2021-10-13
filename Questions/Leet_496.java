
package Questions;

import java.util.*;
class Leet_496
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        HashMap<Integer,Integer>hm=new HashMap<>();
        
        int n1=nums1.length;
        int n2=nums2.length;
        
        for(int i=0;i<n2;i++)
            hm.put(nums2[i],i);
        
        Stack<Integer>st=new Stack<>();
        
        int ng[]=new int[n2];
        ng[n2-1]=-1;
        
        st.push(n2-1);
        
        for(int i=n2-2;i>=0;i--)
        {
            while(st.size()>0 && nums2[i]>nums2[st.peek()])
            {
                st.pop();
            }
            if(st.size()==0)
                ng[i]=-1;
            
            else
                ng[i]=st.peek();
            
            st.push(i);
        }
        
        int res[]=new int[n1];
        
        for(int i=0;i<n1;i++)
        {
            if(hm.containsKey(nums1[i]))
            {
                int ind=ng[hm.get(nums1[i])];
                
                res[i]=ind!=-1?nums2[ind]:-1;
            }
        }
        return res;
    }
}