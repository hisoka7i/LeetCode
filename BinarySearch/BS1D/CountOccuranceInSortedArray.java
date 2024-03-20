public class CountOccuranceInSortedArray {
    public static int findFirst(int[] arr, int n,int x){
        int first = -1;
        int left = 0, right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==x){
                first = mid;
                //search left
                right = mid -1;
            }if(arr[mid]>x){
                //search in left side
                right = mid -1 ;
            }else{
                //search in right side
                left = mid + 1;
            }
        }
        return first;
    }
    public static int findLast(int[] arr, int n,int x){
        int last = -1;
        int left = 0, right = n - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==x){
                last = mid;
                left = mid + 1;
            }else if(arr[mid]>x){
                //search in left
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return last;
    }
}
