/*
85. Maximal Rectangle(Hard)

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = []
Output: 0
*/


//this question is very similar to the maximum area histogram, the only thing we have to do here
//is that we have to calculate the maximum area in the matrix

//so we traverse the matrix row by row, and when we traverse each row, we treat it as a horizontal fixed widht,
// and columns as the bars(like in histogram), we make an array of size equal to the number of columns
//it maintains the height of bars at each levelin the matrix, which is similar to the heights array
//in largest area histogram question. So we simply pass this array after we traverse each row,
//and get the max area, like this we do for all rows, the finally whatever the max area we get 
//we return that

package Questions;

import java.util.Stack;
class Leet_85 {
    public int largestRectangleArea(int[] heights) 
    {
        int n=heights.length;
        
        int rs[]=new int[n];
        
        int max=0;
        Stack<Integer>st=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            while(st.size()!=0 && heights[i]<heights[st.peek()])
            {
                int ele=st.pop();
                rs[ele]=i;
                int ls=-1;
                
                if(st.size()>0)
                {
                    ls=st.peek();
                }
                
                max=Math.max(max,(rs[ele]-ls-1)*heights[ele]);
            }
            st.push(i);
        }
        
        while(st.size()!=0)
        {
            int ele=st.pop();
            int ls=-1;
                
            if(st.size()>0)
            {
                ls=st.peek();
            }
                
            max=Math.max(max,(n-ls-1)*heights[ele]);
        }
        return max;
    }
    
    public int maximalRectangle(char[][] matrix) 
    {
        if(matrix.length==0)
            return 0;
        
        int heights[]=new int [matrix[0].length];
        
        int max=0;
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]-'0'==1)
                {
                    heights[j]+=1;
                }
                else
                {
                    heights[j]=0;
                }
            }
            
            max=Math.max(max,largestRectangleArea(heights));
        }
        
        return max;
        
    }
}