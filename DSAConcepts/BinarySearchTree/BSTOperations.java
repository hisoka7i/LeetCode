package BinarySearchTree;

import TreeTraversal.BinaryTree;

public class BSTOperations {
    public BinaryTree insertInBST(BinaryTree root, int data){
        if(root == null){
            root = new BinaryTree(data);
            root.left = null;
            root.right = null; 
        }
        if(root.data  > data){
            insertInBST(root.left, data);
        }else{
            insertInBST(root.right, data);
        }
        return root;
    }

    public boolean searchInBST(BinaryTree root, int data ){
        if(root == null) return false;
        if(root.data == data)return true;
        
        return root.data > data ? searchInBST(root.right, data):searchInBST(root.left, data);
    }

    /*
     * 3 possible cases
     * if there is no child, "Means simply remove the node"
     * if there is only one child: then simple replace the node with last child
     * if both children are present: then replace the node with highest left child
    */
    public  BinaryTree deleteNode(BinaryTree root, int target){
        if(root == null)return null; //not found
        if(root.data > target){
            BinaryTree left = deleteNode(root.left, target);
        }else if(root.data < target ){
            BinaryTree right = deleteNode(root.right, target);
        }else{
            //this means that we found the node
            if (root.right == null && root.left == null){
                //means this simply make it null
                root = null;
            }else if(root.right != null && root.left != null){
                //means we have both left and right childrens
                BinaryTree temp = findMax(root.left);
                root.data = temp.data;
                //we need to recursively do this process
                root.left = deleteNode(root.left, target);
            }else{
                //means only one child
                if(root.left != null){
                    root = root.left;
                }else{
                    root = root.right;
                }
            }
        }
        return root;
    }

    private void swap(BinaryTree root, BinaryTree temp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }

    private BinaryTree findMax(BinaryTree left) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findMax'");
    }
}
