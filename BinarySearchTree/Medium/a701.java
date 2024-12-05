package BinarySearchTree.Medium;

import BinaryTree.TreeNode;

public class a701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return (new TreeNode(val));

        TreeNode temp = root;
        //we need to find position to insert
        while(temp != null){
            if(temp.val > val){
                if(temp.left == null){
                    //means we need to insert here 
                    temp.left = new TreeNode(val);
                    break;
                }
                //meand move left
                temp = temp.left;
            }else{
                if(temp.right == null){
                    temp.right = new TreeNode(val);
                    break;
                }
                temp = temp.right;
            }
        }

        return root;
    }
}
