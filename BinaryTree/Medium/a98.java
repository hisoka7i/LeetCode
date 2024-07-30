package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class a98 {
    public class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }
        
        boolean helper(TreeNode root, Integer min, Integer max) {
            if (root == null)
                return true;
            
            //min values represent the lower bound, means value of right node
            //so current_node should be less then minimum value
            //max value represent the upper bound, means value of left node
            //so current node value should ne greateer than that
            if ((min != null && root.val <= min) || (max != null && root.val >= max))
                return false;
            
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }
    }
    //This is mostly correct but not entirely correct
    public boolean isValidBST_old(TreeNode root) {
        if(root == null)return true;
        //here we are checking we have correct binary tree or not
        if(root.left != null){
            if(root.left.val >= root.val){
                return false;
            }
        }
        if(root.right != null){
            if(root.right.val <= root.val){
                return false;
            }
        }
        return (isValidBST(root.left) && isValidBST(root.right));
    }
}
