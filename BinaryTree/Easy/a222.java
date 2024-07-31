package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class a222 {
    public int countNodes(TreeNode root) {
        int count = countNodes(root);
        return count;
    }
    public int countnode(TreeNode node)
    {
        if(node == null){
            return 0;
        }
        int left = countNodes(node.left);
        int right = countNodes(node.right);
        return left + right + 1;
    }
}
