package Test;

import java.util.Arrays;
import java.util.OptionalInt;

public class StreamTest {
    public static void main(String[] args){
        int[] nums = {1,2,34,5,6};
        OptionalInt max_value = Arrays.stream(nums).max();
        max_value.getAsInt();
    }
}
