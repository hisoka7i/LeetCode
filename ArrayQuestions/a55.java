package ArrayQuestions;
public class a55{
  public static void main(String[] args){
    int nums = {1,1,2,5,3,1,0,0,1,3};
    int n = nums.length;
    int reach = 0;
    for(int i=0;i<n;i++){
      if(reach<i){
        return false;
      }
      reach = Math.max(reach,i+nums[i]);
    }
    return true;
  }
}
