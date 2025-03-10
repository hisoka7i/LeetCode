package StackAndQueue.PracticeQuestion;

import java.util.Stack;

public class a84_Feb27 {
    public int largestRectangleArea(int[] heights) {
        //Solution is of o(n^2)
        int maxArea = 0;
        for(int i =0; i<heights.length; i++){
            if(i==0){
                maxArea = (i+1)*heights[i];
            }else{
                int area = 0;
                for(int j=i-1;j>=0;j--){
                    area = Math.min(heights[i],heights[j]) + (j-i+1);
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
}
