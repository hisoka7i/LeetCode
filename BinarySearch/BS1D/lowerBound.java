public class lowerBound {
    public static void main(String[] args) {
        int[] sample = {1,2,2,3,4};
        System.out.println(findLower(sample, 2));
    }
    public static int findLower(int[] arr, int target){
        int index = 0;
        if(target<arr[0]){
            return 0;
        }
        if(target>arr[arr.length-1]){
            return arr.length;
        }
        if(target==arr[arr.length-1]){
            return arr.length-1;
        }
        index = binary(arr, 0, arr.length-1, target);

        return index;
    }
    //my logic, this is also working
    public static int binary(int[] arr, int left, int right, int target){
        while(left<right){
            int mid  = (left+right)/2;
            if(arr[mid]>=target){return mid;
            }
            if(arr[mid]==target)return mid;
            else if(arr[mid]>target){
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        // return -1;


        //This is striever's logic for lower bound 
        int ans = arr.length;
        while(left<right){
            
            int mid  = (left+right)/2;
            if(arr[mid]>=target){
            ans = mid;
            right=mid-1;}
            else{
                left = mid+1;
            }
        }
        return ans;
    }
}
