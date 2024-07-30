package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class a110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        if(isReallyBalanced(root) != -1){
            return true;
        }
        return false;
    }

    public int isReallyBalanced(TreeNode root){
        if(root == null)
            return 0;
            int left = isReallyBalanced(root.left);
            int right = isReallyBalanced(root.right);
            if(left == -1 || right ==-1){
                return -1;
            }
            if(Math.abs(left-right)>1){
                return -1;
            }
            return Math.max(left,right)+1;
    }
}
