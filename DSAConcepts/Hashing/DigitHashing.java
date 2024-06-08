//In this problem we are creating a hashing function(array) just to count number of occurance of a digit in a array.
//This is just an example to help understand the basic concept
import java.util.*;

class DigitHashing{
  public static void main(String[] args){
    int[] sample = {1,2,4,5,1,1,2};
    //method1(sample);
    usingHashMap(sample);
  }
  public static void method1(int[] sample){
    int[] hash = new int[13];
    for(int i=0;i<sample.length;i++){
      hash[sample[i]] += 1;
    }
    for(int i=0;i<sample.length;i++){
      System.out.println("Number of occurance of "+sample[i]+" is:"+hash[sample[i]]);
    }
  }
  public static void usingHashMap(int[] sample){
    Map<Integer,Integer> mpp = new HashMap<>();
    for(int i=0;i<sample.length;i++){
            int value = mpp.getOrDefault(sample[i], 0); //This searches for key
            mpp.put(sample[i], value + 1);
    }
    Collection<Integer> lst = null;
    lst = mpp.values();
    System.out.println(lst);
  }
}
