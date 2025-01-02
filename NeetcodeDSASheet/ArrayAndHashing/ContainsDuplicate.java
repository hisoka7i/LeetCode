package NeetcodeDSASheet.ArrayAndHashing;

import java.util.HashSet;

public class ContainsDuplicate {

    //I tried to implement it using XOR but it does not work
    public boolean containsDuplicate2(int[] nums){
        int value = Integer.MIN_VALUE;
        for(int current: nums){
            value = value ^ current;
            if(value == 0)
                return true;
        }
        return false;
    }
    //we are going to use hashset based solution, because search complexity
    //will be 1,
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> seen = new HashSet<>();
        for(int current: seen){
            if(seen.contains(current)){
                return true; //means the value is present
            }
        }
        return false;
    }
}
