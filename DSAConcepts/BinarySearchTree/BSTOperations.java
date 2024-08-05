package BinarySearchTree;

import TreeTraversal.BinaryTree;

public class BSTOperations {

    /*
     * This is code to insert element in a binary search tree
    */
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
    /*
     * To find a element in binary search tree
    */
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

    /*
     * A function to find element
    */
    private BinaryTree findMax(BinaryTree root) {
        // TODO Auto-generated method stub
        //we will move to right till it's not empty;
        if(root == null)return null;
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
    /*
     * A function to convert sorted array into binary search tree
    */
    // public int[] sorted_array = new int[100];
    public BinaryTree BuildBst(int[] num, int left, int right){
        if(left > right) return null;
        BinaryTree new_node = new BinaryTree();
        if(left == right){
            // Base case: only one element in the current subarray
            new_node.data = num[left];
        }else{
            int mid = left + (right - left)/2;
            new_node.left = BuildBst(num, left, mid-1);
            new_node.right = BuildBst(num, mid+1, right);
        }
        return new_node;
    }

    /*
     * finding the kth smallest number
     * count: to keep track of elements
     * k: This the position from which we need to get the element
    */
    public BinaryTree findKthElement(BinaryTree root, int k , int count){
        if(root == null)return null;

        //going towards left, to get the least number
        BinaryTree left = findKthElement(root.left, k, count);
        /*
         * This next line is most important
         * To ensures that once the k-th smallest element is found, 
         * it is returned immediately without further unnecessary traversal.
         * This line will directly give the resu
        */
        if(left != null) return left;
        if(++count == k) return root;

        return findKthElement(root.right, k, count);
    }

    /*
     * Is Binary tree
     * To check if a given tree, is BST or not
    */
    public boolean isBinaryTree(BinaryTree root, int min, int max){
        if(root == null)return false;
        return (root.data > min) && (root.data < max ) && isBinaryTree(root.left, min, root.data) && isBinaryTree(root.right, root.data, max); 
    }

    /*
     * Finding ceiling, value which is just above the given target
     * Keeping a previous pointer, which will store the value
    */
    BinaryTree previous_pointer = null;
    public void floorElement(BinaryTree root, int target){
        if(root == null)return;

        //go to the left side, and from there moment we get first higher value
        floorElement(root.left,target);

        if(root.data == target){
            return;
        }
        if(root.data > target){
            return;
        }
        previous_pointer = root;
        //now going towards the right side
        floorElement(root.right, target);
    }
    /*
     * Finding ceiling
    */
    public void ceilElement(BinaryTree root, int target){
        if(root == null)return;

        //going towards right
        floorElement(root.right, target);

        if(root.data == target)return;
        if(root.data < target)return;
        previous_pointer = root;

        //now going towards left side
        floorElement(root.left, target);
    }
}
