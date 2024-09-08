package Recursion.CountSubSequence;

public class Sample {
    static int k;
    public static void main(String[] args) {
        k = 3;
        int sample[] = new int[]{1,2,3,1,2};
        countNumberOfSubSequence(sample,  0, 0);
    }
    public static int countNumberOfSubSequence(int[] sample, int sum, int index){
        //base condition
        if(index == sample.length-1){
            //need to check for summation
            if(sum == k){
                return 1;
            }else{
                return 0;
            }
        }
        sum += sample[index];
        int left = countNumberOfSubSequence(sample, sum, index+1);

        sum -= sample[index];
        int right = countNumberOfSubSequence(sample, sum, index+1);

        return left+right;
    }
}
