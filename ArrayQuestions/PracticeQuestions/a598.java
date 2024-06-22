package ArrayQuestions.PracticeQuestions;

public class a598 {
    public static void main(String[] args) {
        
    }
    public static int maxCount(int m, int n, int[][] ops) {

        //please take care of edge case as well 

        //Intution of this problem is to find min sub-array in the operations
        //because it will be the most effected aread 
        //and we will simply return that sub array
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int[] current_grid: ops){
            minX = Math.min(minX, current_grid[0]);
            minY = Math.min(minY, current_grid[1]);
        }

        //now we will simply return the multiplication of minX and minY
        return minX*minY;
    }
}
