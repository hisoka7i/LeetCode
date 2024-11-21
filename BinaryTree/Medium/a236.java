package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class a236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //base condition, 
        //we root is null or we find any match then we simple return it
        if(root == null || root == p || root == q){
            return  root;
        }

        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        } 
        else{
            //this means that both are not null and we found out answer
            return  root;
        }
    }
}
