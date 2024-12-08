package BinarySearchTree.Medium;

import BinaryTree.TreeNode;

public class a230 {
    int answer = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }

    //A simple in-order traversal will give me sorted answer, I simple need to get (k-1)
    public void inorder(TreeNode root, int k){
        if(root == null)
            return;
        if(k == 0){
            answer = root.val;
            return;
        }  
        else{
            inorder(root.left, k-1);
            inorder(root.right, k-1);
        }
    }
}
