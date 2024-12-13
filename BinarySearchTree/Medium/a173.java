package BinarySearchTree.Medium;

import BinaryTree.TreeNode;
import java.util.Stack;

public class a173 {
    //The idea behind this solution is to push all the left nodes into the stack
    //Since question requires in-order traversal of binary tree, we can simply push all the left nodes into the stack

    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode root){
        for(; root != null; stack.push(root), root = root.left);
    }
}
