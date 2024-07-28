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


    //finding max element in binary tree
    public int maxElement(BinaryTree root){
        if(root == null){
            return -1;
        }
        int max_value = Integer.MIN_VALUE;
        //we can not use priority queue, since will not let null value inside it
        Queue<BinaryTree> queue = new LinkedList<>();

        //now we will iterate through the binary tree
        while(!queue.isEmpty()){
            BinaryTree current_node = queue.poll();

            if(current_node.data > max_value){
                max_value = current_node.data;
            }

            if(current_node.left != null){
                queue.offer(current_node.left);
            }
            if(current_node.right != null){
                queue.offer(current_node.right);
            }
        }
        return max_value;
    }
}
