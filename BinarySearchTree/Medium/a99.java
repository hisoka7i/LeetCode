package BinarySearchTree.Medium;

import BinarySearchTree.TreeNode;

public class a99 {

    TreeNode[] values = new TreeNode[2];
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        //first we need to find those 2 nodes, which are at the wrong positions(given in application that there are 2 places)
        findWrongPlaces2(root);
        if (values[0] != null && values[1] != null) {
            int temp = values[0].val;
            values[0].val = values[1].val;
            values[1].val = temp;
        }
    }

    //This one will check with prev node
    //we only need to check if it sorted or not
    public void findWrongPlaces2(TreeNode root) {
        //we will simply do a in-order traversal and we will find the nodes we are not sorted
        if (root == null) {
            return;
        }
        //doing the in-order traversal
        findWrongPlaces2(root.left);
        //now we will move to left, doing the in order traversal
        if (prev != null && prev.val > root.val) {
            if (values[0] == null) {
                values[0] = prev;
            }
            values[1] = root;
        }

        //updating the previous value
        prev = root;

        findWrongPlaces2(root.right);

    }

    is one has logic flow , it ony heck with immediate left d

    findWrongPlaces(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.right != null) {
            if (root.val > root.right.val) {
                values[0] = root;
            }
        }

        if (root.left != null) {
            if (root.val < root.left.val) {
                values[1] = root;
            }
        }

        findWrongPlaces(root.left);
        findWrongPlaces(root.right);
    }
}
