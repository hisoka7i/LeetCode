package GreedyAlgorithm.Medium;

import java.util.Arrays;

public class FractionalKnapsack {
    class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        double total = 0.0;
        //sorting the elements by value/weight
        Arrays.sort(arr, (x, y) -> Double.compare((double) y.value / y.weight, (double) x.value / x.weight));
        for (Item item : arr) {
            if( w - item.weight >=0){ //this means that we have space in the sack
                w -= item.weight;
                total += (item.value);
            }else if(w > 0){
                total += ((double)item.value/item.weight)*w; //this type casting is important otherwise we will miss data
            }
        }
        return total;
    }
}
