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
        queue.offer(root);
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

    //find element is present in binary tree
    public boolean isPresent(BinaryTree root, int target){
        if(root == null)
            return false;
        
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            BinaryTree current_node = queue.poll();

            if(current_node.data == target){
                return true;
            }
            if(current_node.left != null)
                queue.offer(current_node.left);
            if(current_node.right != null)
                queue.offer(current_node.right);
        }
        return false;
    }

    //finding minimum dept of a binary tree
    public int minimumDept(BinaryTree root){
        //queue is required for level order tarversal
        if(root == null)
            return 0;
        
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); //to mark speration of levels

        int minimum_count = 0;

        while(!queue.isEmpty()){
            BinaryTree current_node = queue.poll();

            if(current_node != null){
                if(current_node.left == null && current_node.right == null){
                    return minimum_count;
                }
                if(current_node.left != null){
                    queue.offer(current_node.left);
                }
                if(current_node.right != null){
                    queue.offer(current_node.right);
                }
            }else{
                minimum_count++;
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }
        return minimum_count;
    }
}
