import java.util.*;

public class Duplicates{
  public static void main(String[] args){
    int[] arr = {1, 2, 3, 6, 3, 6, 1};
    String str1 = findDuplicates(arr,0,new ArrayList<Integer>(),"");
    System.out.println(str1);
    String[] out = str1.split(" ");
  }
  public static String findDuplicates(int[] nums,int index,ArrayList<Integer> list,String str){
    if(index>nums.length-1){
      return str;
    }
    if(list.contains(nums[index])){
      str += nums[index]+" ";
    }
    else{
      list.add(nums[index]);
    }
    return findDuplicates(nums,index+1,list,str);
  }
}
