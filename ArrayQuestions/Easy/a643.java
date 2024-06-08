package ArrayQuestions;
public class a643 {
    public static void main(String[] args) {
        int[] sample = {1,12,-5,-6,50,3};
        System.out.println(findMaxAvg(sample,4));
    }
    public static double findMaxAvg(int[] sample,int k){
        int sum = 0;
        for(int i = 0; i < k; i ++) 
            sum += sample[i];
        int maxSum = sum;
        for(int i = k; i < sample.length; i ++) {
            sum += sample[i] - sample[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum / k;
    }
}
