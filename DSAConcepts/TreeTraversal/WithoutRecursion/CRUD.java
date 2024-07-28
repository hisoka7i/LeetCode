package TreeTraversal.WithoutRecursion;

import java.util.LinkedList;
import java.util.Queue;

import TreeTraversal.BinaryTree;

public class CRUD {
    //while inserting an element, either in left side or right side
    public BinaryTree insertElement(BinaryTree root, int data){
        //we are going to check every level, if null found then we will simply insert a
        //new binary tree in there

        if(root == null)
            return new BinaryTree(data);

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTree current_node = queue.poll();

            if(current_node.left != null){
                queue.offer(current_node.left);
            }else{
                current_node.left = new BinaryTree(data);
                return root;
            }

            if(current_node.right != null){
                queue.offer(current_node.right);
            }else{
                current_node.right = new BinaryTree(data);
                return root;
            }
        }
        return root;
    }
}
