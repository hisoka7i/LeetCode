package BinarySearchTree.Medium;

import BinaryTree.TreeNode;

public class a235 {
    TreeNode answer = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findIt(root, p, q);
        return answer;
    }
    public void findIt(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;

        // Case 1: If root is greater than both p and q
        if (root.val > p.val && root.val > q.val) {
            findIt(root.left, p, q); // Search in left subtree
        }
        // Case 2: If root is less than both p and q
        else if (root.val < p.val && root.val < q.val) {
            findIt(root.right, p, q); // Search in right subtree
        }
        // Case 3 & 4: root is either p or q or lies between p and q
        else {
            answer = root; // Found LCA
        }
    }
}
