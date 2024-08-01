package BinaryTree.Easy;

import BinaryTree.TreeNode;

public class a700 {
    TreeNode result = null;
    public TreeNode searchBST(TreeNode root, int val) {
        search(root, val);
        return result;
    }
    public void search(TreeNode root,int val){
        if(root == null)return;
        if(root.val == val){
            result = root;
            return ;
        }
        searchBST(root.left, val);
        searchBST(root.right, val);
    }
}
