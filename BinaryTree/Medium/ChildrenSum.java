package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// import org.w3c.dom.Node;

public class ChildrenSum {
    public static int isSumProperty(TreeNode root)
    {
        // add your code here
        if(root == null)return 0;

    }

    public static boolean levelOrder(TreeNode root){
        //we need value for first node
        int prevSum = root.val;

        //Queue to save levels Nodes. 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); //this will mark start of next level

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int currentTotal = 0;
            if(node != null){
                //here we will simply add the values
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                
                currentTotal+= node.val;
            }else{
                if(queue.isEmpty())return true;
                else{
                    //this means that level ended
                    if(prevSum != currentTotal){
                        return false; //means that current level sum is not equal to previous sum
                    }
                    prevSum = currentTotal;
                    queue.offer(null); //this is to notate that the level has changed
                }
            }
        }
    }
}
