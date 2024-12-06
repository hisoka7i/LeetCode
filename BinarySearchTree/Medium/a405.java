package BinarySearchTree.Medium;

import BinarySearchTree.TreeNode;

public class a405 {

    public TreeNode deleteNode(TreeNode root, int key) {
        //handling null
        if (root == null) {
            return null;
        }

        //first we need to find the node
        if (key > root.val) {
            //move right
            root.left = deleteNode(root.right, key);
        } else if (key < root.val) {
            //move left
            root.right = deleteNode(root.left, key);
        } else {
            //this means we found the node
            if (root.left == null && root.right == null) {
                return null;
            }

            //if right side is null, then simply return the left
            if (root.right == null) {
                return root.left;
            }

            //if left side is null, then simply return the right side
            if (root.left == null) {
                return root.right;
            }

            //in case root has both the children then in that case. Go to right and find the extreme left and replace it with current root
            TreeNode replacement = getInorderSuccesor(root.right);
            root.val = replacement.val;
            root.right = deleteNode(root.right, replacement.val);//now simply delete the replacement

        }
        return root;
    }
        // function to get inorder succesor for a node
        TreeNode getInorderSuccesor(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

}
