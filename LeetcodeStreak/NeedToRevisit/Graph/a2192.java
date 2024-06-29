package LeetcodeStreak.NeedToRevisit.Graph;

import java.util.ArrayList;
import java.util.List;

public class a2192 {
    /*
     * We will use DFS, to find ancestor of each node
     * We will require 2 lists, one for all ancestors and one for direct childs
     * We will iterate through, every edge and we will add each child into direct child list
     * We will perform DFS for each node
     * In DFS function, for each child's current node, if it is not present in the all ancestors
     * list, then add the current node to the list ans call the DFS function with child nodes, recursivly 
    */
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        //This will contain all the answers
        List<List<Integer>> answer = new ArrayList<>();
        //This will contain all the direct childrens
        List<List<Integer>> direct_children = new ArrayList<>();

        for(int i=0;i<n;i++){
            answer.add(new ArrayList<>());
            direct_children.add(new ArrayList<>());
        }
        for(int[] current_edge: edges)
            //we are adding direct child of the current vertex/node here
            direct_children.get(current_edge[0]).add(current_edge[1]);
            //here we will perform DFS for current_edge and all its children
        for(int i=0;i<n;i++)
                dfs(i, i, answer, direct_children);
        
        return answer;
    }

    private void dfs(int x, int current, List<List<Integer>> answer, List<List<Integer>> direct_children) {
        // TODO Auto-generated method stub
        for(int current_node: direct_children.get(current))
            if(answer.get(current_node).size() == 0 || answer.get(current_node).get(answer.get(current_node).size()-1)!=x){
                answer.get(current_node).add(x);
                dfs(x, current_node, answer, direct_children);
            }
    }
}
