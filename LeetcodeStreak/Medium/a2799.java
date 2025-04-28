package LeetcodeStreak.Medium;

import java.util.Set;

public class a2799 {


    //bruter  force solution for this question
    public int countCompleteSubarraysUsingBruteForce(int[] nums){
        Set<Integer> set = new java.util.HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int distinctCount = set.size();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            Set<Integer> distinct = new java.util.HashSet<>();
            for(int j=i;j<nums.length;j++){
                distinct.add(nums[j]);
                if(distinct.size() == distinctCount){
                    count++;
                }
            }
        }
        return count;
    }


    //this questtion is not a prefix sum question but a sliding window question
    //this question is asking for the number of complete sub arrays in the array
    public int countCompleteSubarraysUsingPrefixSum(int[] nums) {
        Set<Integer> set = new java.util.HashSet<>();

        int[] prefix = new int[nums.length + 1];

        set.add(nums[0]);
        prefix[0] = 1;
        //here we are making the prefix sum for the array, we are storing the number of unique elements in the array
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1];
            if (set.add(nums[i])) {
                prefix[i]++;
            }
        }

        int distinctCount = set.size();
        int count = 0;

        //now we are checking the number of complete sub arrays in the array
        // I have to make a O(n) solution for this question
    int index = 0;
        for(int i=0;i<prefix.length;i++){
            if(prefix[i] == distinctCount){
                index = i;
                break;
            }
        }

        //now we need to make another array to check the duplicate elements in the array
        int[] duplicate = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                duplicate[i] = duplicate[i-1]+1;
            }else{
                duplicate[i] = 1;
            }
        }

        for(int i = index; i < duplicate.length; i++) {
            count += duplicate[i];
        }

        return count;
    }
}
