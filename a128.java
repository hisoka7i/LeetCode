import java.util.*;
class Solution {
    public static int longestSuccessiveElements(int []a) {
       Set<Integer> integerSet = new HashSet();
       int max_count = 1;
       for(int i=0;i<a.length;i++){
         integerSet.add(a[i]);
       }
       for(Integer i: integerSet){
         if(integerSet.contains(i-1)){
           continue;
         }else{
           int temp = i+1;
           int current_count = 1;
           while(true){
             if(integerSet.contains(temp)){
               temp++;
               current_count++;
             }else{
               break;
             }
             if(max_count<current_count){
               max_count = current_count;
             }
           }
         }
       }
       return max_count;
    }
    public static void main(String[] args){
      int a[] = {1,2,2,1};
      System.out.println(longestSuccessiveElements(a));
    }
}
