package BinarySearch.BS2D;

public class a74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            if(searchElement(matrix[i], target))return true;
        }
        return false;
    }
    public static boolean searchElement(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target)return true;
            if(arr[mid]>=target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}
