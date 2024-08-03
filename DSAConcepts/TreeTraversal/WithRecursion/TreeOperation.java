package TreeTraversal.WithRecursion;

import java.util.PriorityQueue;
import java.util.Queue;

import TreeTraversal.BinaryTree;

public class TreeOperation {

    //This to find the size of the tree
    public int size(BinaryTree root){
        int left_count = root.left == null?0:size(root.left);
        int right_count = root.right == null?0:size(root.right);

        return (1 + left_count + right_count);
    }

    //finding max in binary tree
    public int maxElement(BinaryTree root){
        int maxValue = Integer.MIN_VALUE;
        if(root!=null){
            int left_max = maxElement(root.left);
            int right_max = maxElement(root.right);

            //we are checking for left and right values
            if(left_max > right_max){
                maxValue = left_max;
            }else{
                maxValue = right_max;
            }

            //after checking for left and right, we will now look into the root value
            if(root.data > maxValue){
                maxValue = root.data;
            }
        }  
        return maxValue;      
    }

    public int numberOfHalfNodes(BinaryTree root){
        int count = 0;
        if(root == null)
            return count;
        
        Queue<BinaryTree> queue = new PriorityQueue<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            BinaryTree current_node = queue.poll();

            //we are checking for the half node here
            //and we are incrementing the count if found
            if((current_node.left!= null && current_node.right==null) || (current_node.right!=null && current_node.left==null)){
                count++;
            }
            //we are going to check if left child has any node
            if(current_node.left != null)
                queue.offer(current_node.left);
            //we are going to check if right child has any node
            if(current_node.right != null){
                queue.offer(current_node.right);
            }
        }

        //now we will simply return the count of half node
        return count;
    }

    public boolean ifPresent(BinaryTree root, int target){
        if(root == null)
            return false;
        if(root.data == target)
            return true;
        return (ifPresent(root.left, target) || ifPresent(root.right, target));
    }

    public int height(BinaryTree root){
        if(root == null)
            return 0;
        int left_height = height(root.left);
        int right_height = height(root.right);

        //finding the max between the two side and adding it into the root
        return Math.max(left_height, right_height)+1;
    }

    //checking existance of a path, with given sum
    public boolean isPathPresent(BinaryTree root, int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null && root.data == sum)
            return true;
        return ((isPathPresent(root.left, sum-root.data)) || (isPathPresent(root.right, sum-root.data)))
    }

    //making mirror of a binary tree
    public BinaryTree makeMirror(BinaryTree root){
        BinaryTree temp; 
        if(root != null){
            makeMirror(root.left);
            makeMirror(root.right);

            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    /* finding diameter of a tree
    * diameter of binary tree is equal to height of binary tree.
    * for diameter we will find the right deepest and left deepest and hence we will, have the final value
    */
    int diameter_value = 0;
    public int diameter(BinaryTree root){
        if(root == null)return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);

        if(left + right > diameter_value){
            diameter_value = left + right;
        }

        return Math.max(left, right)+1;
    }

    /*
     * Three pointer binary tree, left, right and sibling
    */
    public void insertSibling(BinaryTree root){
        if(root == null)return;

        //setting sibling for, left child
        if(root.left != null){
            root.left.sibling = root.right;
        }
        //setting sibling for, right child
        if(root.right != null){
            //we need it check,if parent has right sibling or not
            if(root.sibling != null){
                root.right.sibling = root.sibling.left;
            }else{
                root.right = null;
            }
        }
    }

    /*
     * Finding all ancestors of a node
    */
    public boolean findAncestors(BinaryTree root, BinaryTree node){
        if(root == null)return false;
        /*
         * look it left, is equal to node or right is equal to node
         * if not found then keep on look, first left and then right
        */
        if(root.left == node || root.right == node || findAncestors(root.left, node)
        || findAncestors(root.right, node)){
            System.out.println(root.data);
            return true;
        }
        return false;
    }

    /*
     * Finding minimum dept of a tree
    */
    public int findMinDept(BinaryTree root){
        if(root == null)return 0;
        
        //if left-sub tree is null, then we will look in the right side
        if(root.left == null) return findMinDept(root.right)+1;

        //if right-sub tree is null, then we will look in the left side
        if(root.right == null) return findMinDept(root.left)+1;

        //in case of both the child trees are present
        return Math.min(findMinDept(root.left), findMinDept(root.right))+1;
    }
}

