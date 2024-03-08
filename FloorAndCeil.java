public class FloorAndCeil {
    static int findFloor(int[] arr, int n, int target){
        int ans = -1;
        int low = 0, high = n-1;
        while(low<=high){
            //finding the mid
            int mid = low + (high-low)/2;
            if(arr[mid]<=target){
                ans = arr[mid];
                //finding smaller index in left
                low = mid+1;
            }else{
                //find smaller index in right
                high = mid - 1;
            }
        }
        return ans;
    }
    static int findCeil(int[] arr, int n, int target){
        int ans = -1;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>=target){
                ans = arr[mid];
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
