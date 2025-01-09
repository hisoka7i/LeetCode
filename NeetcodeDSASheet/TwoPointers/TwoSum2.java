package NeetcodeDSASheet.TwoPointers;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        if(target < numbers[0])return new int[]{-1,-1};
        int left = 0;
        int right = findFloor(numbers, target);
        while(left < right){
            int value = numbers[left] + numbers[right];
            if(value == target){
                return new int[]{left+1, right+1};
            }
            if(value > target){
                right--;
            }
            if(value < target)
                left++;
        }
        return new int[]{-1, -1};
    }
    public int findFloor(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;
        while (p1 <= p2) {
            int mid = p1 + (p2 - p1) / 2;
            if (numbers[mid] > target) { // Move left if number exceeds target
                p2 = mid - 1;
            } else { // Move right otherwise
                p1 = mid + 1;
            }
        }
        return p2; // p2 points to the floor of target
    }
}
