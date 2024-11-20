package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import BinaryTree.TreeNode;
import java.util.Map;

public class TopView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TopView topView = new TopView();
        List<Integer> result = topView.topViewBT(root);

        System.out.println(result); // Expected Output: [4, 2, 1, 3, 7]
    }

    List<Integer> output = new ArrayList<>();
    //this hashmap will contain row and list of data, associated with it
    Map<Integer, List<Integer>> tree = new HashMap<>();

    public List<Integer> topViewBT(TreeNode root){
        dfs(this, 0);
        //now that we have all the data in tree we simply need to traverse and get
        //it into the linked list
        for(Map.Entry<Integer,List<Integer>> map: tree.entrySet()){
            output.add(map.getValue().get(0));
        }

        return  output;
    }

    //there is a issue with this, it is not maintaining the level so, we do not know if the first in bt, is getting 
    //stored at first place in the map data structure. (It is what chat gpt is saying!)
    public void dfs(TreeNode root, int row){
        //breakout condition 
        if(root == null) return;
        //need to check if row exist or not
        if(!tree.containsKey(row)){
            tree.put(row, new ArrayList<>());
        }
        tree.get(row).add(root.val);
        
        dfs(root.left, row-1);
        dfs(root.right, row+1);
    }

    //This is chatgpt's version, here we are storing level as well
    //and we are only storing the first occurance of the lvl, Not the entire list
    public void dfs(TreeNode root, int row, int level, Map<Integer, Integer> levelMap) {
        // Base case: return if root is null
        if (root == null) return;

        // Check if the row is not present OR current level is closer (higher) than the existing one
        if (!tree.containsKey(row) || levelMap.get(row) > level) {
            tree.put(row, root.val);  // Update top view with the current node
            levelMap.put(row, level); // Update level map for the row
        }

        // Recurse to the left child with row-1 and level+1
        dfs(root.left, row - 1, level + 1, levelMap);

        // Recurse to the right child with row+1 and level+1
        dfs(root.right, row + 1, level + 1, levelMap);
    }
}
