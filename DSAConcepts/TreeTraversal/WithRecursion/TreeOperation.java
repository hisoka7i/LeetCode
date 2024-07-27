package TreeTraversal.WithRecursion;

import java.util.PriorityQueue;
import java.util.Queue;

import TreeTraversal.BinaryTree;

public class TreeOperation {

    //This to find the size of the tree
    public int size(BinaryTree root){
        int left_count = root.left == null?0:size(root.left);
        int right_count = root.right == null?0:size(root.right);

        return (1 + left_count + right_count);
    }

    public int numberOfHalfNodes(BinaryTree root){
        int count = 0;
        if(root == null)
            return count;
        
        Queue<BinaryTree> queue = new PriorityQueue<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            BinaryTree current_node = queue.poll();

            //we are checking for the half node here
            //and we are incrementing the count if found
            if((current_node.left!= null && current_node.right==null) || (current_node.right!=null && current_node.left==null)){
                count++;
            }
            //we are going to check if left child has any node
            if(current_node.left != null)
                queue.offer(current_node.left);
            //we are going to check if right child has any node
            if(current_node.right != null){
                queue.offer(current_node.right);
            }
        }

        //now we will simply return the count of half node
        return count;
    }
}
