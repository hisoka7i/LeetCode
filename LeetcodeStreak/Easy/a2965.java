package LeetcodeStreak.Easy;
public class a2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = (n*n) + 1;
        int[] hashtable = new int[total];

        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                hashtable[grid[i][j]]++; //this will maintain the count of values
            }

        //now we will simply iterate through the hashtable to find our answer
        int[] answer = new int[2];

        for(int i=1;i<hashtable.length;i++){
            if(hashtable[i] == 0){
                answer[1] = i;
            }
            if(hashtable[i] == 2){
                answer[0] = i;
            }
        }

        return answer;
    }
}
