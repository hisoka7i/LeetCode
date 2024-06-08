package ArrayQuestions.Concepts;
class MajorityElement{
  public static void main(String[] args){
    int[] arr1 = {1,1,2,3,3,3,3,3,3,4,4,4,2,4};
    int len = arr1.length;
    int count = 0;
    int element = 0;
    int major = count;
    for(int i=0; i<len; i++){
      for(int j=0; j<len; j++){
        if(i!=j){
          if(arr1[i] == arr1[j]){
          count++;
          if(count>major){
            major = count;
            element = arr1[i];
          }
        }
      }
      }
      count = 0;
    }
    System.out.println(element);
    }
}
