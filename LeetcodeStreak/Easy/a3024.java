import java.util.HashSet;
import java.util.Set;

class Test{
    public static void main(String[] args) {
        System.err.println(" sfd");
    }
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if(a+b <= c || a+c <= b || b+c <= a){
            return "none";
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        if(set.size() == 1){
            return "Equilateral";
        }else if(set.size() == 2){
            return "Isosceles";
        }else{
            return "Scalene";
        } 
    }
}