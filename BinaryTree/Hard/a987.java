package BinaryTree.Hard;

import BinaryTree.TreeNode;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize
    // the node with a value
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class a987 { 
    //This data structure we contain <row, map<column, sortedNodes_values>>> 
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> hashmap;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        hashmap = new TreeMap<>();
        Dfs(root, 0, 0);

        //now we have all the values in out data structure
        // result reconstruction
        for(int i : hashmap.keySet()){
            List<Integer> temp = new ArrayList<>();
            //we will get row and it's values
            TreeMap<Integer, PriorityQueue<Integer>> t  = hashmap.get(i);
            for(int j : t.keySet()){
                PriorityQueue<Integer> pq = t.get(j);
                while(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            result.add(temp);
        }
        return result;
    }

    //a DFS function which will travel every node and store it's value into our datastructure
    public void Dfs(TreeNode root, int col, int row){
        //breakout condition
        if(root == null) return;

        TreeMap<Integer, PriorityQueue<Integer>> t = hashmap.getOrDefault(col, new TreeMap<>());
        PriorityQueue<Integer> pq = t.getOrDefault(row, new PriorityQueue<>()); //to check if a PQ is present at row or not
        pq.add(root.val); //this will automatically sort
        t.put(row, pq);
        hashmap.put(col, t);

        Dfs(root.left, col-1, row+1);
        Dfs(root.right, col+1, row+1);
    }
    

    //this was my solution, and it became to complicated so I stopped working on it.
    //Plus there is one more issue which is that I did not read all the conditions properly
    //but striever solution was somewhere close to mine
    boolean leftToRight = true;
    int vertical = 0;
    List<List<Integer>> output = new ArrayList<>();
    List<Integer> current = new ArrayList<>();

    List<List<Integer>> output_left_half = new ArrayList<>();
    List<List<Integer>> output_right_half = new ArrayList<>();

    
    public void preOrderTraversal(TreeNode root) {

        //we need to track value of vertical pointer, 
        if (leftToRight) {
            vertical++;
            leftToRight = !leftToRight;
        } else {
            vertical--;
            leftToRight = !leftToRight;
        }
        if(vertical != 0){

        }
        //in this we need to add, current data into the output
        current.add(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
}
