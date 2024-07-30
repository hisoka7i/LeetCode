package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class a404 {
    int left_sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)return left_sum;

        leftTotal(root, false);
        return left_sum;
    }
    public int leftTotal(TreeNode root, boolean isLeft){
        if(root == null){
            return left_sum;
        }
        if(root.left == null && root.right == null){
            if(isLeft)
                left_sum += root.val;
        }
        leftTotal(root.left, true);
        leftTotal(root.right, false);
        return left_sum;
    }
}
