package TreeTraversal.WithRecursion;

import TreeTraversal.BinaryTree;

public class CRUD {

    //we will find the first null and insert in there
    public boolean insertElement(BinaryTree root, int data){
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
