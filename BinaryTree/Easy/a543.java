package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class a543 {
    int diameter_value = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return (diameter_value);
    }
    public int diameter(TreeNode root){
        if(root == null)return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);

        if((left + right)> diameter_value){
            diameter_value = left + right;
        }

        return Math.max(left, right)+1;
    }
}
