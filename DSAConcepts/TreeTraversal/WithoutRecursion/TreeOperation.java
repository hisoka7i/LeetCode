package TreeTraversal.WithoutRecursion;

import java.util.LinkedList;
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

    //I have not totally understood this one
    //but after doing dry run i did get the answer. It worked like magic :P
    public BinaryTree deepestNodeInTree(BinaryTree root){
        if(root == null)
            return null;
        
        //using queue we will find the last node. 
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);

        BinaryTree last_node = root;
        while (!queue.isEmpty()) {
            last_node = queue.poll();
            //we are simply going to iterate over every level
            //and we will save the last node in the last_node variable
            if(last_node.left != null){
                queue.offer(last_node.left);
            }
            if(last_node.right != null){
                queue.offer(last_node.right);
            }
        }
        return last_node;
    }
}
