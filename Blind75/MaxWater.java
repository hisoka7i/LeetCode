import java.util.HashSet;
import java.util.Set;

class MaxWater{

	//this is also passing 
	public int maxArea(int[] height) {
	int n = height.length;
        int left_max = 0;
	int right_max = n - 1;
	int l = 0;
	int r = n-1;
	int max_area = Integer.MIN_VALUE;
	while(l < r){
		if(height[l]  > height[left_max]){
			left_max = l;
		}
		if(height[r] > height[right_max]){
			right_max = r;
		}
		l++;
		r--;
		max_area = Math.max(max_area, Math.abs(right_max - left_max) * Math.min(height[right_max], height[left_max]));
	}
	return max_area;
    }


	public int maxArea(int[] height) {
	int left = 0;
	int right = n - 1;
	int max_area = Integer.MIN_VALUE;
	while(left < right){
	int c_a = Math.min(height[left],height[right]) * (right - left);
	max_area = Math.max(max_area, c_a);
	if(height[left] > height[right]){right--;}
	else{left++;}}
	return max_area;
}
	}
	
}