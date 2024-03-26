
public class a48 {
    class Solution {
        //This is solution provided by striver
        //Find the traverse of matrix and then rotate every row.
        public void rotate(int[][] matrix) {
            if(matrix[0].length==0)return;
            int len = matrix[0].length;
            for(int i=0;i<matrix.length;i++){
                for(int j=i;j<len;j++){
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
            for(int i=0;i<len;i++){
                for(int j=0;j<len/2;j++){
                    int temp = 0;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length - 1 - j];
                    matrix[i][matrix.length - 1 - j] = temp;
                }
            }
            return;
        }
    }
}
