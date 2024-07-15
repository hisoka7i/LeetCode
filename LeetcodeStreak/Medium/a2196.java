package LeetcodeStreak.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class a2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        //crating a set of values,
        Set<Integer> children_set = new HashSet<>();
        //This set will help us find the parent. 
        Map<Integer, int[]> childrenHashMap = new HashMap<>();

        for(int[] current_description: descriptions){
            //according to question at 0 index is parent node
            int parent = current_description[0];
            //according to question at 1 index is child node
            int child = current_description[1];

            boolean is_left = current_description[2]==1;

            //adding child into the children hashset 
            children_set.add(child);

            //adding the data into the hash map 
            childrenHashMap.putIfAbsent(parent, new int[]{-1,-1});

            if(is_left){
                childrenHashMap.get(parent)[0] = child;
            }else{
                childrenHashMap.get(parent)[1] = child;
            }
        }

        //getting the value of head node
        int head_node_value = 0;
        for(int parent: childrenHashMap.keySet()){
            if(!children_set.contains(parent)){
                head_node_value = parent;
            }
        }

        return constructNode(head_node_value, childrenHashMap);
    }
    public TreeNode constructNode(int currentNode_value, Map<Integer, int[]> childrenMap){
        TreeNode new_node = new TreeNode(currentNode_value);
        if(childrenMap.containsKey(currentNode_value)){
            int[] children = childrenMap.get(currentNode_value);

            if(children[0]!=-1){
                //This means we have left childwith us
                //we will need to insert the left child into the left place
                new_node.left = constructNode(children[0], childrenMap);
            }
            if(children[1]!=-1){
                //This means we have right child with us
                new_node.right = constructNode(children[1], childrenMap);
            }
        }
        return new_node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
