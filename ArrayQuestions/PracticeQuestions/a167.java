package ArrayQuestions.PracticeQuestions;

public class a167 {
    public static void main(String[] args) {
        
    }
    public static int[] twoSum(int[] numbers, int target) {
      int left = 0;
      int right = numbers.length-1;
      while(left<right){
        int value = numbers[left]+numbers[right];
        if(value==target){
            return new int[]{left+1,right+1};
        }
        if(value>target){
            right--;
        }else{
            left++;
        }
      }
      return new int[]{-1,-1};   
    }
}
