package LeetcodeStreak.Medium;

public class a1605 {
    //find valid matrix, given row and column sums
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        //finding length of row and column
        int row_count = rowSum.length;
        int column_count = colSum.length;

        //making matrix to maintain sum of row and column 
        int[] current_row_sum = new int[row_count];
        int[] current_column_sum = new int[column_count];

        //making a matrix to save the result
        int[][] result_matrix = new int[row_count][column_count];


        //now iterating over the matrixes
        for(int row=0; row<row_count; row++){
            for(int column = 0; column<column_count;column++){

                // getting the remaining values in row_sum
                int remaining_row = rowSum[row] - current_row_sum[row];
                //getting the remaining values in column_sum
                int remaining_column = colSum[column] - current_column_sum[column];

                result_matrix[row][column] = Math.min(remaining_row,remaining_column);

                //saving the values into the current values matrix
                current_row_sum[row] += result_matrix[row][column];
                current_column_sum[column] += result_matrix[row][column];
                
            }
        }
        return result_matrix;
    }
}
