package LeetcodeStreak.Medium;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    List<List<Integer>> values;
    public ProductOfNumbers() {
        values = new ArrayList<>();
        values.add(new ArrayList<>());
    }
    
    public void add(int num) {
        if(num == 0){
            //this means that we added a break in the presum
            values.add(new ArrayList<>());
            return;
        }
        List<Integer> presum = values.get(values.size());
        int size = presum.size();
        if(size == 0){
            presum.add(num);
        }else{
            presum.add(num * presum.get(size-1)); //added this 
        }
    }
    
    public int getProduct(int k) {
        int length = values.get(values.size() - 1).size(); 
        if(k > length){
            return 0;
        }
        List<Integer> presum = values.get(values.size()-1);
        return (presum.get(length-1)/presum.get(length - k));
    }
}
