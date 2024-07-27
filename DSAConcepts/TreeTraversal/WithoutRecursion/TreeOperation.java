package TreeTraversal.WithoutRecursion;

import java.util.PriorityQueue;
import java.util.Queue;

import TreeTraversal.BinaryTree;

public class TreeOperation {
    public int size(BinaryTree root){
        Queue<BinaryTree> queue = new PriorityQueue<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            BinaryTree current_node = queue.poll();
            count++;
            if(current_node.left!=null){
                queue.offer(current_node.left);
            }
            if(current_node.right != null)
                queue.offer(current_node.right);
        }
        return count;
    }
}
