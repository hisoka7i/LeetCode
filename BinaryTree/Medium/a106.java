package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class a106 {
    // We will leverage the properties of post order and in Order,
    //in post order last node is the root;
    //in inOrder first half is the left tree and right half is the right tree

    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int postOrderIndex;
    //for post order, first build right of tree and then left of tree.
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int left, int right) {
        // TODO Auto-generated method stub
        //break out condition
        if(left > right)return null;

        int rootVal = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(rootVal);

        //we will be getting the inOrder index of the value
        int inOderIndex = inOrderMap.get(rootVal);

        //now we will construct the binary tree
        root.right = buildTree(postorder, inOderIndex+1, right);
        root.left = buildTree(postorder, left, inOderIndex-1);
        // throw new UnsupportedOperationException("Unimplemented method 'buildTree'");
        return root;
    }
}
