package BinarySearch.BS2D;

public class Max1 {
    
    public static int lowerBound(int[] arr, int m, int target){
        int low = 0;
        int high = m-1;
        int ans = m;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>=target){
                ans = mid;
                //look for smaller index on the left half
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int countNumbers(int[][] matrix, int m,int n){
        int count_max = -1;
        int index = -1;

        //going through the rows
        for(int i=0;i<n;i++){
            int count_current = n - lowerBound(matrix[i], count_max, 1);
            if(count_current>count_max){
                count_max = count_current;
                index = i;
            }
        }

        return index;
    }
}
