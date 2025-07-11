public class MinInSortedArray {
  public int findMin(int[] nums) {
      int n = nums.length;
      if(n == 1){
          return nums[0];
      }
      if(n == 2){
          return nums[0] < nums[1] ? nums[0] : nums[1];
      }
      int l = 0;
      int r = n - 1;
      while(l < r){
          int m = l + (r-l)/2;
          if(m-1 >= 0){
              if( nums[m-1] > nums[m] ){
                  return nums[m];
              }
          }
          if( m+1 < n){
              if(nums[m + 1] < nums[m]){
                  return nums[m+1];
              }
          }
          if( nums[l] < nums[m]){
              l = m + 1;
          }else{
              r = m;
          }
      }
      return nums[0];
  }
}
