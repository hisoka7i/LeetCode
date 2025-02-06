package LeetcodeStreak.Medium;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.print.attribute.HashAttributeSet;

public class a1726 {
    //correct approach, is to find all the pairs and then from there get a count
    public int tupleSameProduct(int[] nums){
        if(nums.length < 4){
            return 0;
        }

        //We need a collection to store all the products and their pair count
        Map<Integer, Integer> productCount = new HashMap<>();
        int count = 0;
        //find all the distinct pairs
        for(int i=0;i<nums.length; i++){
            for(int j=i+1;j<nums.length;j++){ // to make sure they are distinct
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        for(int freq: productCount.values()){
            count += 4*(freq*(freq-1));
        }
        return count;
    }
    //My approach was to get all he factors of that  number and then from there derives something.
    public int tupleSameProduct2(int[] nums) {
        if(nums.length < 4){
            return 0;
        }
        int[] count = new int[1];
        Map<Integer, Set<Integer>> hashtable = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length;j++){
                if(nums[i] != nums[j]){
                    int a = nums[i];
                    int b = nums[j];
                    
                    int multiply = a*b;
                    if(hashtable.containsKey(multiply)){
                        hashtable.get(multiply).add(a);
                        hashtable.get(multiply).add(b);
                    }else{
                        hashtable.put(multiply, new HashSet(a,b));
                    }
                }
            }
        }

        //now we need to count all the possible tuples
        hashtable.forEach((key,value)->{
            if(value.size() >=4){
                if(value.size()%2 != 0){
                    //this means that we a key which matches the value;
                    value.forEach(current->{
                        if(current == key){
                            value.remove(current);
                        }
                    });
                }else{
                    int pairsNumber = value.size()/2;
                    while(pairsNumber > 0){
                        count[0] *= pairsNumber-1;
                    }
                    count[0] = (count[0]/2)* 8;
                }
            }
        });
        return count[0];
    }
}
