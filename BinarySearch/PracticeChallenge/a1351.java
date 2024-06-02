package BinarySearch.PracticeChallenge;

public class a1351 {
//     1351. Count Negative Numbers in a Sorted Matrix
// Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
    public static void main(String[] args) {
        
    }
    public static int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int count  = 0;
        //taking 2 pointers approach
        int r = n-1;
        int c = 0;
        while(r>=0 && c<m){
            if(grid[r][c]<0){
                --r;
                count += m - c ;
            }else{
                ++c;
            }
        }
        return count;
    }
}
