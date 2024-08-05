package TreeTraversal.WithoutRecursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import TreeTraversal.BinaryTree;

/*
 * Steps
 * 1. Visit the root
 * 2. While traversal level l, keep all elements at the level l+1 in the queue
 * 3. Repeat this till all the levels
*/
public class LevelOrderTraversal {

    //need to do dry run of this 
    public List<List<Integer>> levelOrderTraversalTopDown(BinaryTree root){
        //this will contain all the list
        List<List<Integer>> result = new ArrayList<>();

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        //the null represent, the level change
        queue.offer(null); 

        List<Integer> current = new ArrayList<>();
        while(!queue.isEmpty()){
            BinaryTree current_tree = queue.poll();
            if(current_tree!=null){
                //adding data into the current
                current.add(current_tree.data);
                if(current_tree.left != null){
                    queue.add(current_tree.left);
                }
                if(current_tree.right != null){
                    queue.add(current_tree.right);
                }
            }else{
                List<Integer> current_copy = new ArrayList<>(current);

                result.add(current_copy);
                current.clear();
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }
        return result;
    }


    //printing, level order data in reverse
    public void fromDownTopLevelOrder(BinaryTree root){
        if(root == null)
            return;
        //we will require stack for this
        Stack<BinaryTree> stack = new Stack<>();
        
        //we will require a queue for level traversal
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); //null to represent level division

        while(!queue.isEmpty()){
            BinaryTree current_node = queue.poll();
            if(current_node != null){
                if(current_node.left != null)
                    queue.offer(current_node.left);
                if(current_node.right != null)
                    queue.offer(current_node.right);
                
                //adding current_node in stack, so that when we will retreat this
                //we will get data in reverse 
                stack.push(current_node);
            }else{
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().data + " ");
        }
    }

    //finding max sum at level
    public int maxLevelSum(BinaryTree root){
        int max_sum = 0;
        int current_level_sum = 0;

        Queue<BinaryTree> queue = new LinkedList<>(); //This is required for BFS
        queue.offer(root);
        queue.offer(null); //this will be used for sepration of levels

        while(!queue.isEmpty()){
            BinaryTree current_node = queue.poll();
            if(current_node != null){
                //we are incrementing current level sum here
                current_level_sum += current_node.data;
                if(current_node.left != null){
                    queue.offer(current_node.left);
                }
                if(current_node.right != null){
                    queue.offer(current_node.right);
                }
            }else{
                if(current_level_sum > max_sum){
                    max_sum = current_level_sum;
                }
                current_level_sum = 0;
                if(queue.isEmpty() == false ){
                    queue.offer(null);
                }
            }
        }
        return max_sum; 
    }
}
