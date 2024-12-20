package BinarySearchTree.Medium;

import BinarySearchTree.TreeNode;

public class LargestBSTInBT {
    //we are going to do a postorder traversal, while keeping track of the size    
    class TreeNodeInfo {
        boolean isBST;
        int size;
        int min;
        int max;
        
        TreeNodeInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        return helper(root).size;
    }

    public TreeNodeInfo helper(TreeNode node){
        if(node == null){
            return new TreeNodeInfo(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        //recursively check if left and right treeNodes
        TreeNodeInfo left = helper(node.left);
        TreeNodeInfo right = helper(node.right); 

        //now from above line we have already travelled all the nodes
        //we are now at the bottom 
        if(left.isBST && right.isBST && node.val > left.max && node.val < right.min){
            //this means it is a valid bst
            int size = left.size + right.size  + 1;
            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);

            return  new TreeNodeInfo(true, size, min, max);
        }else{
            //not a valid bst
            return new TreeNodeInfo(false, 0, 0, 0);
        }
    }

    // Main function to test the functionality
    public static void main(String[] args) {
        LargestBSTInBT solution = new LargestBSTInBT();

        // Creating a sample binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        // Calling the function to find the largest BST subtree
        int largestBSTSize = solution.largestBSTSubtree(root);
        
        // Printing the result
        System.out.println("Largest BST Subtree Size: " + largestBSTSize);
    }
}
