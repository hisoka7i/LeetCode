package NeetcodeDSASheet.BinarySearch;

public class Searchin2dArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            if(searchInrow(matrix[i], target)){
                return true;
            }
        }
        return false;
    }
    public boolean searchInrow(int[] row, int target){
        int l = 0, r = row.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(row[mid] == target){
                return true;
            }else if(row[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }
    
}
