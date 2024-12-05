package BinarySearchTree.Easy;

import BinaryTree.TreeNode;

public class Floor {
    public int findFloor(TreeNode root){
        int floor = -1;
        if(root == null)return -1;
        while(root != null){
            if(key > root.val){
                //means move right
                floor = root.val;
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return floor;
    }
}
