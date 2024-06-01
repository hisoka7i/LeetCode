package ArrayQuestions;
import java.util.ArrayList;
import java.util.List;

public class a54 {
    public static void main(String[] args){
        int[][] sample = {{1,2,3},{4,5,6},{7,8,9}};
        spiral(sample);
    }
    //This is solution provided by striver 
    // Move from left to right top++
    //Move to top to bottom, right--
    //move from right to left, bottom--
    //move from bottom to top, left++
    public static void spiral(int[][] matrix){
        int h = matrix.length;
        int w = matrix[0].length;
        int top = 0, bottom = h-1, left = 0, right = w-1;
        List<Integer> output = new ArrayList<>();
        while(top<=bottom && left<=right){
            //moving left to right
            for(int i=left;i<=right;i++){
                output.add(matrix[top][i]);
            }
            top++;

            //moving top to bottom
            for(int i=top;i<=bottom;i++){
                output.add(matrix[i][right]);
            }
            right--;

            //moving right to left
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    output.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //moving bottom to top
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    output.add(matrix[i][left]);
                }
                left++;
            }
        }
        System.out.println(output);
    }
}
