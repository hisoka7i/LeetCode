package TreeTraversal.WithRecursion;

import TreeTraversal.BinaryTree;

public class CRUD {

    //we will find the first null and insert in there
    public boolean insertElement(BinaryTree root, int data){
        //This code has logical flaw, 
        //This will go till last left and add it there
        //This will not check, if there is any place in between, on the right
        if(root == null){
            root = new BinaryTree(data);
            return true;
        }
        if(root.left == null){
            root.left = new BinaryTree(data);
            return true;
        }
        if(root.right == null){
            root.right = new BinaryTree(data);
            return true;
        }

        return (insertElement(root.left, data)||insertElement(root.right, data));
    }
}
