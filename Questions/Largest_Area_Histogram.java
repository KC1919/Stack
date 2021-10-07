/*
84. Largest Rectangle in Histogram  (Hard)

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
*/

package Questions;

import java.util.Stack;
public class Largest_Area_Histogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int rs[] = new int[n];  //array to store right smaller of every element

        int max = 0;
        Stack<Integer> st = new Stack<>();

        //what happens here is that, when a element comes, if it is smaller than the "top" element of the stack
        //we start a while loop, and that loop runs till there encounter's an element smaller than the current element
        //and the current element keeps popping the greater element, and for those greater element being popped
        //their right smaller becomes the current element that is popping them out of the stack.
        //if the stack gets empty an no smaller element than current element is found, then the left
        //boundary for the current element becomes -1

        for (int i = 0; i < n; i++) 
        {
            //if the current element is smaller then the element at the top of the stack
            //it means the current element is the right boundary for the peek element in the stack
            while (st.size() != 0 && heights[i] < heights[st.peek()]) 
            {
                int ele = st.pop();  //so we pop the peek element
                rs[ele] = i;         //store its right smaller index int the array
                int ls = -1;       //and we take left smaller for the peek element to be -1 as default

                //we check if the stack is not empty, then it means the top elemnt now, is the left boundary
                if (st.size() > 0) 
                {
                    ls = st.peek();  //for the "ele"
                }
                int width=rs[ele] - ls - 1;  //we take out the width

                max = Math.max(max, (width) * heights[ele]);  //and calculate the area
            }
            st.push(i); //and push the current element index in the stack
        }

        while (st.size() != 0) 
        {
            int ele = st.pop();
            int ls = -1;

            if (st.size() > 0) {
                ls = st.peek();
            }

            max = Math.max(max, (n - ls - 1) * heights[ele]);
        }
        return max;
    }

}
