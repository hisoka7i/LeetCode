package BinaryTree.Hard;

import BinaryTree.*;
public class a124 {
    int maxPathsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         maxForNode(root);
         return  maxPathsum;
    }
    //for every node find left sum, right sum, 
    //total sum = left sum + right sum + val, isme se simply max find krke return kr do
    public int maxForNode(TreeNode root){
        if(root == null )
            return 0;
        
        int left = Math.max(0, maxForNode(root.left)); // 0 incase if it returns -1
        int right = Math.max(0, maxForNode(root.right));

        maxPathsum = Math.max(maxPathsum, root.val + left + right);

        return root.val + Math.max(right, left);
    }
}
