package BinaryTree.Medium;

import BinaryTree.TreeNode;

public class a110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true; //null checking done
        }
        //intution behind the solution is to get height of left and right and then check if subtraction is greateer than one or not
        //if >1 then simply return false
        return (isItBalanced(root)!=-1);
    }

    private int isItBalanced(TreeNode root) {
        if(root == null)
            return 0;
        // TODO Auto-generated method stub
        int left = isItBalanced(root.left);
        int right = isItBalanced(root.right);

        if(left == -1 || right == -1){
            return -1;
        }

        if(Math.abs(left-right)>1){
            return -1;
        }

        return  Math.max(left, right)+1;
    }
}
