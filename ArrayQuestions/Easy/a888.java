package ArrayQuestions;

public class a888 {
    //Fair Candy Swap

    public static void main(String[] args) {
        
    }
    //Basically we need to equal the sum of these two arrays by swapping one of element from both array,
// Lets's Suppose sum of aliceSizes is SumA and sum of bobSizes is SumB

// So we have to do the follow
//     SumA-x+y = SumB +x-y
    
//     where x is candies given by alice
//     and y is candies given by bob

public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        int bobSum = 0;
        for(int i: aliceSizes){
            aliceSum+=i;
        }

        for(int i:bobSizes){
            bobSum+=i;
        }

        int diff = (aliceSum-bobSum)/2;

        for(int i=aliceSizes.length-1;i>=0;i--){
            for(int j=bobSizes.length-1;j>=0;j--){
                if(aliceSizes[i]-bobSizes[j] == diff){
                    return new int[]{aliceSizes[i],bobSizes[j]};
                }
            }
        }
        return new int[]{-1,-1};
}
}
