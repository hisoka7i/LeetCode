package BinaryTree.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import BinaryTree.TreeNode;
import java.util.PriorityQueue;

public class a102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //we are going to do, BFT using this
        List<List<Integer>> output = new ArrayList<>();
        //we are going to maintain, a queue for BFS, where we will put current treenode and using, null we will mark, next level
        Queue<TreeNode> queue = new PriorityQueue<>();

        queue.offer(root);
        queue.offer(null); //this marks the first level

        //One collection to maintain data of current level
        List<Integer> leveldata = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode current_level_node = queue.poll();
            if(current_level_node!=null){
                //this means that we have a tree node, 
                leveldata.add(current_level_node.val);
                if(current_level_node.left != null){
                    //means that left child exist
                    queue.offer(current_level_node.left);
                }
                if(current_level_node.right != null){
                    //means that right child exist
                    queue.offer(current_level_node.right); 
                }
            }else{
                output.add(leveldata);
                if(queue.isEmpty() == false){
                    queue.offer(null);
                    leveldata = new ArrayList<>();
                }else{
                    break;
                }
            }
        }
        return output;
    }
}
