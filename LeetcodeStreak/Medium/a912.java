package LeetcodeStreak.Medium;

public class a912 {
    public void quickSort(int[] nums, int si, int ei) {
        if(si >= ei) {
            return;
        }
        int pivotIdx = partition(nums, si, ei);
        quickSort(nums, si, pivotIdx-1);
        quickSort(nums, pivotIdx+1, ei);
    }
    public int partition(int[] nums, int si, int ei) {
        int mid = si + (ei-si)/2;
        swap(nums, mid, ei);
        for(int j=si; j<ei; j++) {
            if(nums[j] < nums[ei]) {
                swap(nums, j, si);
                si++;
            }
        }
        swap(nums, ei, si);
        return si;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
}
