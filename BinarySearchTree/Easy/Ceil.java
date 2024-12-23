package BinarySearchTree.Easy;

import BinaryTree.TreeNode;

public class Ceil {
    public int findCeil(TreeNode root){
        int ceil = -1;
        if(root == null)return ceil;

        while(root != null){
            if(root.val == ceil){
                return ceil;
            }
            if(key > root.val){
                //means move right
                root = root.right;
            }else{
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }
}
