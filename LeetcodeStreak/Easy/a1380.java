package LeetcodeStreak.Easy;

import java.util.ArrayList;
import java.util.List;

public class a1380 {
    //Lucky number in a matrix
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result_list = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                int currrent_number = matrix[i][j];
                if(checkInRow(matrix, currrent_number, i) && checkInColumn(matrix, currrent_number, j)){
                    result_list.add(currrent_number);
                }
            }
        }
        return result_list;
    }

    public boolean checkInRow(int[][] nums, int current_number, int current_row){
        for(int i=0;i<nums[current_row].length;i++){
            if(current_number > nums[current_row][i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInColumn(int[][] nums, int current_number, int current_column){
        for(int i=0;i<nums.length;i++){
            if(current_number < nums[i][current_column]){
                return false;
            }
        }
        return true;
    }
}
