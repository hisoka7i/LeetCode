package BinaryTree.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.TreeNode;

public class a101 {

    public boolean isSymmetric(TreeNode root){
        if(root == null)
            return true;
        
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;


        return node1.val == node2.val && (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
    }


    //This method is not passing all the test cases
    public boolean isSymmetricOld(TreeNode root) {
        //we will do level order traversal, for every level we will check for 
        //reciprocal, 
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); //This is to mark level difference

        List<Integer> data_level = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current_node = queue.poll();
            if(current_node != null){
                if(current_node.left != null && current_node.right == null)
                    return false;
                if(current_node.right != null && current_node.left == null)
                    return false;
                
                if(current_node.left != null)
                    queue.offer(current_node.left);
                if(current_node.right != null)
                    queue.offer(current_node.right);

                data_level.add(current_node.val);
            }else{
                
                if(isPalindrome(data_level) == false){
                    return false;
                }
                data_level.clear();
                if(queue.isEmpty() == false){
                    queue.offer(null);
                }
            }
        }
        return true;
    }

    // Method to check if a List of integers is a palindrome
    public boolean isPalindrome(List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;

        // Check pairs of elements from start and end
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false; // If any pair is not equal, it's not a palindrome
            }
            start++;
            end--;
        }
        return true; // If all pairs are equal, it's a palindrome
    }
}
