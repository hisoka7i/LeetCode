package BinaryTree.Easy;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.TreeNode;

public class a145 {
    List<Integer> output = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            output.add(root.val);
        }
        return  output;
    }
}
