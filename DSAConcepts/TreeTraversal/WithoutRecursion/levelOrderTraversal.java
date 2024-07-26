package TreeTraversal.WithoutRecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import TreeTraversal.BinaryTree;

/*
 * Steps
 * 1. Visit the root
 * 2. While traversal level l, keep all elements at the level l+1 in the queue
 * 3. Repeat this till all the levels
*/
public class levelOrderTraversal {
    public List<List<Integer>> levelOrderTraversal(BinaryTree root){
        //this will contain all the list
        List<List<Integer>> result = new ArrayList<>();

        Queue<BinaryTree> queue = new PriorityQueue<>();
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
    }
}
