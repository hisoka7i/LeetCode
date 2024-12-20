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
}
