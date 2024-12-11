package BinarySearchTree.Medium;

import BinarySearchTree.TreeNode;

public class a1008 {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = build(preorder, Integer.MAX_VALUE);
        return root;
    }

    public TreeNode build(int[] p, int upperBound){
        if(i == p.length || p[i] > upperBound){
            return null;
        }
        TreeNode root = new TreeNode(p[i++]);

        root.left = build(p, root.val);
        root.right = build(p, upperBound);
        return root;
    }
}
