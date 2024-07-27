package TreeTraversal.WithRecursion;

import java.util.LinkedList;
import java.util.Queue;

import TreeTraversal.BinaryTree;

public class Traversal {
    public void PreOrder(BinaryTree root){
        if(root == null)
            return;
        System.out.println(root.data);
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public void InOrder(BinaryTree root){
        if(root==null)
            return;
        InOrder(root.left);
        System.out.println(root.data);
        InOrder(root.right);
    }

    public void PostOrder(BinaryTree root){
        if(root == null)
            return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.println(root.data);
    }

    
}
