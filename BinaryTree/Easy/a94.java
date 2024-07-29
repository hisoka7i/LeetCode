package BinaryTree.Easy;

import java.util.LinkedList;
import java.util.List;

import BinaryTree.TreeNode;

// import javax.swing.tree.TreeNode;

public class a94 {
    List<Integer> result = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;
    }
}
