package LeetcodeStreak.Medium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a1110 {
    //making a set to contain all the values that needs to be deleted
    Set<Integer> to_be_delete;
    List<TreeNode> result_list;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        to_be_delete = new HashSet<>();
        result_list = new ArrayList<>(); 

        // adding data into the set
        for(int current_value: to_delete){
            to_be_delete.add(current_value);
        }
        helperFunction(root, true);
        return result_list;
    }
    public TreeNode helperFunction(TreeNode node, boolean is_root){
        if(node == null)return null;
        boolean deleted = to_be_delete.contains(node.val);
        if(is_root && !deleted)
            result_list.add(node);
        node.left = helperFunction(node.left, deleted);
        node.right = helperFunction(node.right, deleted);
        return deleted?null:node;
    }
}
