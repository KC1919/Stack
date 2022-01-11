

import java.util.LinkedList;
public class Leet_114 
{
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) 
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode head;
    public void flatten_1(TreeNode node) 
    {
        if(node==null)
            return;
        
        flatten_1(node.right);
        flatten_1(node.left);
        
        node.right=head;
        node.left=null;
        head=node;
    }

    public void flatten_2(TreeNode node)
    {
        LinkedList<TreeNode>list=new LinkedList<>();
        
        helper(node, list);
        
        TreeNode fnode=list.remove();
        
        if(list.size()==0)
            return;
        
        TreeNode prev=new TreeNode();
        
        TreeNode head=list.getFirst();
        while(list.size()>0)
        {
            TreeNode rem=list.remove();
            prev.right=rem;
            prev.left=null;
            
            prev=rem;
        }
        prev=head;
        node.left=null;
        node.right=head;
    }

    public void helper(TreeNode node, LinkedList<TreeNode>list)
    {
        if(node==null)
            return;
        
        TreeNode n=new TreeNode(node.val,null,null);
        list.add(n);
        
        helper(node.left,list);
        helper(node.right,list);
        
    }

}
