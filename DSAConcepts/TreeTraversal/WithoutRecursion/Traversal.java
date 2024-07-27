package TreeTraversal.WithoutRecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import TreeTraversal.BinaryTree;

public class Traversal {
    public void PreOrder(BinaryTree root){
        //we are goinf to require a colleciton for this
        //handling the null
        if(root == null){
            return;
        }

        //we are going to need a collection to store result
        List<Integer> result = new ArrayList<>();

        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            BinaryTree temporary = stack.pop();
            result.add(temporary.data);
            if(temporary.right != null)
                stack.push(temporary.right);
            if(temporary.left != null)
                stack.push(temporary.left);

            //we have inserted right and then left, so that, we will have
            //the left child on top,
        }
    }

    public void InOrder(BinaryTree root){
        if(root == null)
            return;
        //a flag to check if, recursion is completed or not
        boolean done = false;
        BinaryTree current_node = root;
        //A stack is required to maintain the Binary trees
        Stack<BinaryTree> stack = new Stack<>();
        //a collection to store the result
        List<Integer> result =  new ArrayList<>();
        while(!done){
            if(current_node != null){
                //we are going to go down the tree, till we get last left and save it 
                //into the stack
                stack.push(current_node);
                current_node = current_node.left;
            }else{
                current_node = stack.pop();
                //adding data into the result list
                result.add(current_node.data);
                current_node = current_node.right;
            }
        }
        System.out.println(result);
    }

    public void PostOrder(BinaryTree root){
        Stack<BinaryTree> stack = new Stack<>();

        //result for list
        List<Integer> result = new ArrayList<>();
        stack.push(root);

        BinaryTree previous = null;

        while(!stack.isEmpty()){
            BinaryTree current = stack.pop();
            if( previous == null || previous.left == current || previous.right == current){
                //travel from top to bottom,
                //if currrent has left/right child then add into stack else pop()
                if(current.left!=null){
                    stack.push(current.left);
                }else if(current.right != null){
                    stack.push(current.right);
                }else if(current.left == previous){
                    if(current.right != null){
                        stack.push(current.right);
                    }
                }
            }else{
                result.add(current.data);
                stack.pop();
            }
            previous = current;
        }

        System.out.println(result.toString());
    }
}
