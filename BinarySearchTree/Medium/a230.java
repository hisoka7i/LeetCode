package BinarySearchTree.Medium;

import BinaryTree.TreeNode;

public class a230 {
    int count;
    int answer = -1;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return answer;
    }

    //A simple in-order traversal will give me sorted answer, I simple need to get (k-1)
    public void inorder(TreeNode root){
        if(root == null)
            return;

        //move towards left
        inorder(root.left);

        //decreement the count
        count--;
        if(count == 0){
            answer = root.val;
            return;
        }

        inorder(root.right);
    }
}
