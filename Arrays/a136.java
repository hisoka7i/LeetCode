public class a136 {
    public static void main(String[] args){
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    //other method is to use some kind of collection
    public static int singleNumber(int[] nums) {
        int u = 0;
        for(int n: nums){
            u ^= n;
        }
        return u;
    }
}
