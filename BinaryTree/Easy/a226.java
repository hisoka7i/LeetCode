package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class a226 {
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp;
        if(root != null){
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}
