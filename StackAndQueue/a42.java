package StackAndQueue;

public class a42 {
    //Trapping rain water
    public static void main(String[] args) {
        
    }
    
    public static int trap(int[] height) {
        //amount of water stored is min(Max(left),Max(right)) - currentBuilding height
    //space comlexity is O(n)

    //better solution is prefix sum 

    //prefix max array 
    //suffix max array 

    //there is a even better solution which is of two pointer

    //one left pointer to save the left max 
    //second left pointer which will iterate arary from left
    //one right pointer to save the right max
    //second right pointer which will iterate array from right
    int left = 0;
    int leftMax = 0;
    int right = height.length-1;
    int rightMax = 0;
    int result = 0;

    while (left<=right) {
        //here we are making sure that 
        //there is a wall of higher or equal length to save the water
        if(height[left]<=height[right]){
            if(height[left]>leftMax){
                leftMax = height[left];
            }else{
                //here we will check the water level compared
                //to current height of building 
                result += leftMax - height[left];
            }
            left++;
        }else{
            //here we are already assured that there is some 
            //wall on left which is higher than right 
            if(height[right]>rightMax){
                rightMax = height[right];
            }else{
                result += rightMax-height[right];
            }
            right--;
        }
    }
    return result;
    }
}
