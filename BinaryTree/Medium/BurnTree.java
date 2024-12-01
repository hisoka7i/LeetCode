
import org.w3c.dom.Node;

import BinaryTree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BurnTree {

    public static int minTime(TreeNode root, int target) {
        // Your code goes here

        //First we need to find the Address of the target
        TreeNode target_address = findTarget(root, target);

        //we also need to make a collection to map parent node of every node
        Map<TreeNode, TreeNode> parentmap = new HashMap<>();
        setParentMap(parentmap, null, root);

        //now for every step we need to burn children and parent simulatenously
        return burnTree(target_address, parentmap);
    }

    private static int burnTree(TreeNode target_address, Map<TreeNode,TreeNode> parentmap) {
        // TODO Auto-generated method stub
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target_address);
        visited.add(target_address);

        int time = 0;
        while(!queue.isEmpty()){
            boolean burnedSomething = false;

            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode current = queue.poll();

                //now we will burned the left child if present
                if(current.left != null && !visited.contains(current.left)){
                    queue.offer(current.left);
                    visited.add(current.left);
                    burnedSomething = true;
                }

                //now we will try to burn right child
                if(current.right != null && !visited.contains(current.right)){
                    queue.offer(current.right);
                    visited.add(current.right);
                    burnedSomething = true;
                }

                if(parentmap.get(current) != null && !visited.contains(parentmap.get(current))){
                    queue.offer(parentmap.get(current));
                    visited.add(parentmap.get(current));
                    burnedSomething = true;
                }

                if(burnedSomething){
                    time++;
                }
            }
        }

        return time;
        // throw new UnsupportedOperationException("Unimplemented method 'burnTree'");
    }

    private static void setParentMap(Map<TreeNode, TreeNode> parentmap, TreeNode parent, TreeNode root) {
        // TODO Auto-generated method stub\
        if (root == null) {
            return;
        }
        if (parent != null) {
            parentmap.put(root, parent);
            // return;
        }

        setParentMap(parentmap, root, root.left);
        setParentMap(parentmap, root, root.right);
        // throw new UnsupportedOperationException("Unimplemented method 'setParentMap'");
    }

    private static TreeNode findTarget(TreeNode root, int target) {
        // TODO Auto-generated method stub
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }

        TreeNode left = findTarget(root.left, target);
        if (left != null) {
            return left;
        }

        return findTarget(root.right, target);
        // throw new UnsupportedOperationException("Unimplemented method 'findTarget'");
    }

}
