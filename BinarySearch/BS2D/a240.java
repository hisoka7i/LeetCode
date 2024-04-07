package BinarySearch.BS2D;

public class a240 {
    public  boolean searchMatrix(int[][] matrix, int target) {
        //I have attached image as well, which explain its solution image name is SearchA2Darray240
        //we have to assume starting position such that we have ascending or decending data
        //when we move across rows then to column


        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0, col = m-1;
        while(row<n && col>=0){
            if(matrix[row][col]==target)return true;
            if(matrix[row][col]>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
