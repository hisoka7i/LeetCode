package TreeTraversal;

import java.util.List;

import TreeTraversal.WithoutRecursion.LevelOrderTraversal;

public class Test {
    public static void main(String[] args) {
        // Creating the binary tree
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        // Creating an instance of the class containing the level order method
        LevelOrderTraversal test = new LevelOrderTraversal();
        
        // Running the method and capturing the output
        // List<List<Integer>> result = test.levelOrderTraversalTopDown(root);

        test.fromDownTopLevelOrder(root);
        // Printing the result
        // System.out.println(result.toString());
    }
}
