package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class a671 {
    long first = Long.MAX_VALUE, second = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        searchForIt(root);
        return (second == Long.MAX_VALUE)?-1:(int)second;
    }
    public void searchForIt(TreeNode root){
        if(root == null){
            return;
        }

        first = Math.min(root.val, first);
        if(root.val > first && root.val < second){
            second = root.val;
        }
        searchForIt(root.left);
        searchForIt(root.right);
    }
}
