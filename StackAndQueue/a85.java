package StackAndQueue;

import java.util.Stack;

public class a85 {
    public static void main(String[] args) {
        int[][] mar = new int[3][4];
        System.out.println(mar.length);
    }
    //Maximal Rectangle

    public static int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        //for every row we need to find the largest histogram
        //we already have a function to return largest area of histogram
        //try to draw above lines on a sheet of paper, to help visualise
        int[] histogram = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1')
                    histogram[j]++;
                else
                    histogram[j]=0;
            }
            int area = largestRectangleArea(histogram);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        //array to maintain left minimum
        int[] left_minimum = new int[n];

        //array to maintain right minimum 
        int[] right_minimum = new int[n];
        //stack to maintain, indexes
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                left_minimum[i]=0;
            else
                left_minimum[i]=stack.peek()+1;
            stack.push(i);
        }
        stack.clear();
        for(int j=n-1;j>=0;j--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[j]){
                stack.pop();
            }
            if(stack.isEmpty())
                right_minimum[j] = n-1;
            else   
                right_minimum[j] = stack.peek()-1;
            stack.push(j);
        }

        //iterating through the array to find the max area 
        int maximum = 0;
        for(int i=0;i<n;i++){
            maximum = Math.max(maximum, (right_minimum[i]-left_minimum[i]+1)*heights[i]);
        }

        return maximum;
    }
}
