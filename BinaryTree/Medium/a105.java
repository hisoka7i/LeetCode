package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class a105 {

    //A collection to maintain, inorder elements and their index's
    Map<Integer, Integer> inOrdered = new HashMap<>();
    int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //we will be leveraging the properties of InOrder, like left of list will be left binary tree
        //Pre order will be, first element will be the root
        for (int i = 0; i < inorder.length; i++) {
            inOrdered.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right) {
        // TODO Auto-generated method stub
        //break out condition
        if(left > right) return null;

        //we will get root value
        int rootVal = preorder[preOrderIndex++];
        //now we will make a root node
        TreeNode root = new TreeNode(rootVal);

        //now we will get the inOrder position of root value, so that we can split left and right
        int inOrderIndex = inOrdered.get(rootVal);

        //now we need to construct, left tree and right tree
        root.left = buildTree(preorder, left, inOrderIndex-1);
        root.right = buildTree(preorder, inOrderIndex + 1, right);

        return root;
        // throw new UnsupportedOperationException("Unimplemented method 'buildTree'");
    }
}
