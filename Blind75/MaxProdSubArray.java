
import java.util.Arrays;
import java.util.OptionalInt;

public class MaxProdSubArray {
    public int maxProduct(int[] nums) {
        OptionalInt value = Arrays.stream(nums).max();
        int result = value.getAsInt();
        int current_min = 1;
        int current_max = 1;

        for(int n: nums){
            int temp = n * current_max;
            current_max = Math.max(temp, Math.max(current_min * n, n));
            current_min = Math.min(temp, Math.min(current_min * n, n));

            result = Math.max(result, current_max);
        }

        return result;
    }
}
