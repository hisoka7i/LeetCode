package BinaryTree.Medium;

import java.util.LinkedList;

import BinaryTree.TreeNode;
import java.util.Queue;
import javax.xml.transform.Templates;

public class a662 {
    class NodeInfo{
        TreeNode node;
        long num;
        int level;
        public NodeInfo(TreeNode node, long num, int level){
            this.node = node;
            this.num = num;
            this.level = level;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)return 0;

        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 1, 0));

        int res = 0;
        int prelev = 0;
        long prenum = 1;

        while(!queue.isEmpty()){
            NodeInfo current = queue.poll();
            TreeNode node = current.node;
            long num = current.num;
            int level = current.level;

            if(level > prelev){
                //this means that we in next level, 
                prelev = level;
                prenum = num;
            }

            res = Math.max(res, (int)(num - prenum + 1));

            if(node.left != null){
                queue.offer(new NodeInfo(node.left, 2*num, level+1));
            }
            if(node.right != null){
                queue.offer(new NodeInfo(node.right, 2*num + 1, level+1));
            }
        }
        return res;
    }
}
