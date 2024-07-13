class Solution {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
    //Steps to solve the problem
    //1. Identify the sorted half
    //2. If element is not is the sorted half then, remove the sorted half from equation
    //One the either half will always be sorted.
    //Striever Solution
    public static int Striever(int[] arr, int target){
        int low=0, high=arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target)return mid;
            //This means the first half is sorted
            if(arr[low]<=arr[mid]){
                //If target lies in the sorted half
                if(target>=arr[low] && target<=arr[mid]){
                    //serach only in the first half
                    high = mid -1;
                }
                //target does not lie in the sorted half
                else{
                    //search only in the second half
                    low = mid + 1;
                }
            }
            //Other half is sorted
            else{
                //left portion will be eliminated
                if(target>=arr[mid] && target <= arr[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    //This is someOne else Solution
    public static int search(int[] nums, int target) {
        return search1(nums,target,0,nums.length-1);
    }
    static int search1(int[] nums, int target, int s, int e){
        if(s>e){
            return -1;
        }
        int m = s + (e-s)/2;
        if (nums[m]==target){
            return m;
        }
        //Identifying the sorted 
        if(nums[s]<=nums[m]){ //checking if the first half is sorted or not
            if(target>=nums[s] && target<=nums[m]){
              //checking if target is in first half or not
                return search1(nums,target,s,m-1);
            }
            else{
              //in case target is in 2nd half.
                return search1(nums,target,m+1,e);
            }
        }
        //checking if target is in second half.
        if(target >= nums[m] && target<=nums[e]){
            return search1(nums,target,m+1,e);
        }
        //suppose we need to search 6 in 5,6,1,2,3,4. In this case.
        return search1(nums,target,s,m-1);
    }

    //my revision
    public static int revision(int[] nums,int target){
        int low = 0, high = nums.length - 1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            //searching for the sordted half 
            if(nums[low]<=nums[mid]){
                //this means that first half se sorted
                if(target>= nums[low] && target<=nums[mid]){
                    //means target high in this, less than mid part 
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                //this means that the second half is sorted
                if(target>=nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid  - 1;
                }
            }
        }
        return -1;
    }
}
