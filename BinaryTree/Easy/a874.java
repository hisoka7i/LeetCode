package BinaryTree.Easy;

import java.util.ArrayList;
import java.util.List;
import BinaryTree.TreeNode;

public class a874 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leave_list_one = new ArrayList<>();
        List<Integer> leave_list_two = new ArrayList<>();

        addInfoToList(root1, leave_list_one);
        addInfoToList(root2, leave_list_two);

        
        return true;
    }
    public void addInfoToList(TreeNode root, List<Integer> list){
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        if(root.left != null)
            addInfoToList(root.left, list);
        if(root.right != null)
            addInfoToList(root.right, list);
    }
}
