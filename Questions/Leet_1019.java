/*
1019. Next Greater Node In Linked List

You are given the head of a linked list with n nodes.

For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.

Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.

 

Example 1:


Input: head = [2,1,5]
Output: [5,5,0]
Example 2:


Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]
 */

import java.util.Stack;
public class Leet_1019 
{
    public class ListNode 
    {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) 
        {
            this.val = val;
        }

        ListNode(int val, ListNode next) 
        {
            this.val = val;
            this.next = next;
        }
    }

    public int[] nextLargerNodes(ListNode head) 
    {
        ListNode curr = head, next = null, prev = null;

        int count = 0;
        while (curr != null) 
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        Stack<Integer> st = new Stack<>();

        int ng[] = new int[count];
        ng[count - 1] = 0;

        st.push(prev.val);

        prev = prev.next;
        int i = count - 2;

        while (prev != null) 
        {
            while (st.size() > 0 && prev.val >= st.peek()) 
            {
                st.pop();
            }

            if (st.size() == 0)
                ng[i] = 0;

            else
                ng[i] = st.peek();

            st.push(prev.val);
            prev = prev.next;
            i--;
        }

        return ng;
    }
}
