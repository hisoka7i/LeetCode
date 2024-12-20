package LeetcodeStreak.Medium;

import LeetcodeStreak.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.PriorityQueue;
import java.util.Queue;
public class a2415 {
        //Need to do BFS here, and for every odd level instead of queue, I need to have a stack
        public TreeNode reverseOddLevels(TreeNode root) {
            //This queue will be used to maintain node 
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                List<TreeNode> currentNodes = new ArrayList<>();
                
                //now we will iterate through current level nodes
                for(int i=0;i<size;i++){
                    TreeNode current = queue.poll();
                    currentNodes.add(current);

                    if(current.left != null)queue.add(current.left);
                    if(current.right != null)queue.add(current.right);
                }
                //, and if level is odd then we will swap 
                if(level%2 == 1){
                    int left = 0, right = currentNodes.size() - 1;
                    while(left < right){
                        int temp = currentNodes.get(left).val;
                        currentNodes.get(left).val = currentNodes.get(right).val;
                        currentNodes.get(right).val = temp;
                        left++;
                        right--;
                    }
                }
                level++;
            }
            return root;
        }
}
