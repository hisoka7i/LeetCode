package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import javax.print.attribute.standard.MediaSize;
// import javax.swing.tree.TreeNode;

public class a199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewAPI(root, result, 0);
        return  result;
    }

    public void rightSideViewAPI(TreeNode root, List<Integer> output, int level){
        if(root == null)return;

        //we will only add data if, it is right most on the current level
        if(output.size() == level){
            output.add(root.val);
        }
        //we will get to right, because we only want the right view
        rightSideViewAPI(root.right, output, level+1);
        rightSideViewAPI(root.left, output, level+1);
    }

    ///This is using BFS
    public List<Integer> rightSideViewMine(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        // rightSide(output, root);
        // return output;

        //we will need a queue for level order, traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); //this is level 0

        List<Integer> level_values = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.remove();
            if(currentNode != null){
                if(currentNode.left != null)
                queue.offer(currentNode.left);
                if(currentNode.right != null)
                queue.offer(currentNode.right);
                level_values.add(currentNode.val);
            }else{
                result.add(level_values);
                if(queue.isEmpty() == false){
                    //this means that that queue has data in it
                    queue.add(null);
                    level_values = new ArrayList<>();
                }else{
                    break;
                }
            }
        }
        //now that data with us, we need to iterate through it and for every level we ned to get the last element.
        for(List<Integer> current_level: result){
            output.add(current_level.get(current_level.size()-1));
        }
        return output;
    }

    //this will not work/
    public void rightSide(List<Integer> output, TreeNode root){
        if(root == null)return;
        output.add(root.val);
        rightSide(output, root.right);
    }

    //make a level order traversal. 
    //and from every level get the last value
    // public void levelOrder()
}
