public class a1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1; // Ensure l starts at 1 to prevent division by zero
        int h = 0;
        
        for (int num : nums) {
            h = Math.max(num, h);
        }

        int minimumSize = h;
        while (l < h) {
            int mid = l + (h - l) / 2;
            
            if (numberOfBags(nums, mid) <= maxOperations) { 
                minimumSize = mid; 
                h = mid; 
            } else {
                l = mid + 1; // Increase bag size
            }
        }
        return minimumSize;
    }

    public int numberOfBags(int[] nums, int size) {
        int count = 0;
        for (int num : nums) {
            count += (num + size - 1) / size-1; // Correct operation count
        }
        return count;
    }
}
