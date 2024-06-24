package MediumProblems;

public class a1423 {
    //intution
    /*
     * we will take k element window from the left for and get sum of it 
     * second step: we will take k-1 from left and 1 element from right and get sum of it/ 
     * like we will  go l = 0 and r = k
     */
    public int maxScore(int[] cardPoints, int k) {
        int leftsum = 0, rightSum = 0, maxSum = 0, n = cardPoints.length;
        if(k>=cardPoints.length){
            for(int current_card: cardPoints){
                leftsum += current_card;
            }
            return maxSum;
        }
        //for initial window
        for(int i = k - 1; i >= 0 ; i--){
            leftsum += cardPoints[i];
        }
        maxSum = leftsum;
        int right_index = n - 1;
        for(int i=k-1;i>=0;i--){
            leftsum = leftsum - cardPoints[i];
            rightSum = rightSum + cardPoints[right_index];
            right_index = right_index - 1;
            maxSum = Math.max(maxSum, leftsum + rightSum);
        }
        return maxSum;
    }
}
