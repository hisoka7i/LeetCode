package BinaryTree.Medium;

import java.util.ArrayList;

// import org.w3c.dom.Node;
import BinaryTree.TreeNode;
import java.util.List;
import javax.naming.spi.DirStateFactory;

public class RootToLeaf {

    private static List<List<Integer>> result = new ArrayList<>();

    //all root to leave paths
    public static List<List<Integer>> Paths(TreeNodede root) {
        // code here
        allThePaths(new ArrayList<>(), root);
        return result;
    }

    public static void allThePaths(List<Integer> path, TreeNode root) {
        if (root == null) {
            return;
        }

        //we will add current value in the path
        path.add(root.val);
        if (root.left == null && root.right == null) {
            //this means that this a leaf node.
            //we need to add it's path into the result
            result.add(new ArrayList<>(path));
        } else {
//now traverse to left
            allThePaths(path, root.left);
            allThePaths(path, root.right);
        }
        //do the backtracking 
        //My assumption was wrong in think, that arraylist will automatically shrink
        path.remove(path.size() - 1);
    }
}
