package StackAndQueue;

import java.util.Stack;

public class a84 {
    // Largest Rectangle in Histogram
    public static void main(String[] args) {
        
    }
    public static int largestRectangleArea(int[] heights) {
     //we will make a previous smaller stack 
     int n = heights.length;
     int[] left_smaller = new int[n];

     //we will make a next smaller stack
     int[] right_smaller = new int[n];

     //for left smaller we will iterate from left compare with stack for the prev smaller 
     //for right smaller we will iterate from right and compare with stack for the next higher
     
     //we will create a stack which will keep track of the indexes
     Stack<Integer> indexes = new Stack<>();

     //formula that we will implement is right_smaller - left_smaller + 1 * width


     //making a loop for the left smaller
     for(int i=0;i<n;i++){
        while(!indexes.isEmpty() && (heights[indexes.peek()]>=heights[i])){
            indexes.pop();
        }
        if(indexes.isEmpty())
            left_smaller[i]=0;
        else 
            left_smaller[i]=indexes.peek()+1;
        indexes.push(i);
     }
     //clearing the stack
     indexes.clear();
     //making a loop for right smaller
     for(int i=(n-1);i>=0;i--){
        while(!indexes.isEmpty() && (heights[indexes.peek()]>=heights[i])){
            indexes.pop();
        }
        if(indexes.isEmpty())
            right_smaller[i] = n-1;
        else   
            right_smaller[i] = indexes.peek()-1;

        indexes.push(i);
     }


     //since now we have left smaller and right smaller
     int max_histogram = 0;
     for(int i=0;i<n;i++){
        max_histogram = Math.max(max_histogram, (heights[i]*(right_smaller[i]-left_smaller[i]+1)));
     }

     return max_histogram;
    }
}
