package LeetcodeStreak.Medium;

public class a684 {

    /*This is wrong solution*/
    public int[] findRedundantConnection(int[][] edges) {
        boolean[] visited = new boolean[1001];
        for(int i=0;i<edges.length;i++){
            if(visited[edges[i][0]] && visited[edges[i][1]]){
                return new int[]{edges[i][0],edges[i][1]};
            }
            visited[edges[i][0]] = true;
            visited[edges[i][1]] = true;
        }

        return new int[]{0,0};
    }
}
