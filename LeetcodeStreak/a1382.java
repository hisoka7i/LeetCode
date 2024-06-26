package LeetcodeStreak;

import java.util.ArrayList;
import java.util.List;

public class a1382 {
    public static void main(String[] args) {
        
    }
    /*
     * Intitution to solving this Question
     * 1 . Perform an in-order traversal, which in turn will give us a sorted array
     * 2 . Now by using recursion, make a BST 
     */
    List<Integer> sorted_data = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);
        return finalBST( 0, sorted_data.size() -1 );
    }

    private void inOrderTraversal(TreeNode root){
        if(root == null)return;
        inOrderTraversal(root.left);
        sorted_data.add(root.val);
        inOrderTraversal(root.right);
    }
    private TreeNode finalBST(int start, int end){
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(sorted_data.get(mid));
        root.left = finalBST(start, mid - 1);
        root.right = finalBST( mid + 1, end);
        return root;
    }
}
