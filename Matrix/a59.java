package Matrix;

public class a59 {
    public int[][] generateMatrix(int n) {
        int[][] output = new int[n][n];
        int top = 0,left = 0, right = n-1, bottom= n-1;
        int value = 1;
        while(left < right && top < bottom){
            //moving from left to right
            for(int i=left;i<=right;i++){
                output[top][i] = value++;
            }
            top++;
            //movong from top to bottom
            for(int i=top;i<=bottom;i++){
                output[right][i] = value++;
            }
            right--;
            //moving from right to left
            for(int i=right;i>=left;i--){
                output[bottom][i] = value++;
            }
            bottom++;
            //moving from botton to top
            for(int i=bottom;i>=top;i--){
                output[i][left] = value++;
            }
            left++;
        }
        return output;
    }
}
