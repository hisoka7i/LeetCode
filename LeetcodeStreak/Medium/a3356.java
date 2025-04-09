import java.util.Arrays;

class a3356 {
    public static void main(String[] args) {
        int[] nums = {5};
int[][] queries = {
    {0, 0, 5},
    {0, 0, 1},
    {0, 3, 1}
};
// minZeroArray(nums, queries);
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        //we are going to implement binary search on the queries 
        //and then we will find the floor
        int left = 0, right = queries.length;
if(!makingItZero(nums, queries, right))return -1;
        while (left<=right) {
            int mid = left + (right-left)/2;
            if(makingItZero(nums, queries, mid)){
                //this means that the thing is working, we can also check for the left
                right = mid-1;
            }else{
                left = mid+ 1;
            }
        }
        return left;
    }

    public boolean makingItZero(int[] nums, int[][] queries, int k){
        //using difference array we can find if the thing is working or not
        int[] dfarray = new int[nums.length + 1];

        for(int i=0;i<k;i++){
            int start = queries[i][0], end = queries[i][1], value = queries[i][2];

            dfarray[start] += value;
            dfarray[end+1] -= value;
        }

        //now that we have difference array we will simply need to do the prefix sum
        int sum = 0;
        for(int i=0;i<dfarray.length-1;i++){
            sum += dfarray[i];
            if(sum < nums[i]) return false;
        }
        return true;
    }

    public static int minZeroArray2(int[] nums, int[][] queries) {
        if(nums.length == 1){
            nums[0] = 0;
            return 0;
        }
        // First need to sort the queries on the basis of starting index
        // Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
    
        // Now I need an array of size nums which will help me keep track of 0s
        boolean[] track = new boolean[nums.length];
    
        int zero_count = 0; // This represents the number of 0s that I have, and once this is equal to the length of nums
        // it means that I have completed the iteration
    
        // Now I need to iterate through all of the queries
        for (int i = 0; i < queries.length; i++) {
            // Now I will have the starting value and ending value and the limit
            int start = queries[i][0];
            int end = queries[i][1];
            int value = queries[i][2];
    
            while (start <= end) {
                // If the value is greater than or equal to nums[start], then make it zero
                //else subtract from 
                if (nums[start] <= value) {
                    nums[start] = 0;
    
                    // Check if the track array was false; if yes,
                    // then change the track array start value to true and increment the zero_count
                    if (!track[start]) {
                        track[start] = true;
                        zero_count++;
                    }
                }else{
                    nums[start] -= value;
                }
                start++;
            }
    
            if (zero_count == nums.length) {
                return i + 1; // This means these many queries were used to make the entire array zero
            }
        }
    
        return -1; // If not all elements can be zeroed after all queries
    }
    
}
