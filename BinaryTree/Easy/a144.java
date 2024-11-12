package BinaryTree.Easy;

import java.util.ArrayList;
import java.util.List;
import BinaryTree.TreeNode;
public class a144 {
    List<Integer> output = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){
            output.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return output;
    }
}
