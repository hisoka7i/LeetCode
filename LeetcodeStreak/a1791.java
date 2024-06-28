package LeetcodeStreak;

public class a1791 {
    //we are trying to find centre of graph here
    /* 
     * Intution, here we will find, number of connection to a node
     */
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;

        //in this array we will keep in degree of all the edges
        int[] degree_count = new int[n+1];

        for(int[] edge: edges){
            degree_count[edge[0]]++;
            degree_count[edge[1]]++;
        }

        for(int i=0;i<degree_count.length;i++){
            if(degree_count[i] == n-1){
                return i;
            }
        }

        return -1;
    }
}
