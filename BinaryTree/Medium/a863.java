package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import BinaryTree.TreeNode;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class a863 {

    //solution is to first find the address of the target, using DFS
    //When we find the address of the target, then we will do search left and right from the address
    //from the address, and we will maintain a counter which will increase its value, till we find the distance
    //we will also maintain a set of visited nodes.
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (target == null || root == null) {
            return result;
        }

        //we are going to build a parent map, which will store parent of each node
        Map<TreeNode, TreeNode> parentNode = new HashMap<>();

        //building the parent map
        buildParentMap(root, null, parentNode);

        //now that we have all the nodes and their parent nodes in a collection
        //we will do BFS from target 
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>(); //this will maintain the visited counter

        queue.offer(target);
        visited.add(target);

        int current_distance = 0;

        while(!queue.isEmpty()){
            if(current_distance == k){
                for(TreeNode node : queue){
                    //for that current level, we will add all of them into the result
                    result.add(node.val);
                }
                break; //exit from while
            }

            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();

                //now visit the left child
                if(current.left != null && !visited.contains(current.left)){
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                //now visit the right child
                if(current.right != null && !visited.contains(current.right)){
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                //visit parent
                TreeNode parent = parentNode.get(current);
                if(parent != null && !visited.contains(parent)){
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            current_distance++;
        }
        return  result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode,TreeNode> parentNode) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'buildParentMap'");
        if(node == null) return;

        if(parent != null){
            parentNode.put(node, parent); //mapping current node to its parent
        }

        buildParentMap(node.left, node, parentNode);
        buildParentMap(node.right, node, parentNode);
    }
}
