import java.util.HashSet;
import java.util.Set;

class 3Sum{
	//I was on the right track almost there 
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
		int n = nums.length - 1;
		for(int i = 0 ; i< n; i++){
			if(nums[i] > 0){
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int j = n - 1;
			int remaining = nums[i] + nums[j];
			int k = n - 2; //second last element
			while(k >= 0){
				if(remaining == nums[k]){
					output.add(Arrays.asList(nums[i],nums[j],nums[k]));
					
					
				}
				k--;
			}
		}
		return output;
    }
	
	
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length;
		for(int i=0;i<n-2;i++){
			if(nums[i] > 0)break;
			if(i > 0 && (nums[i - 1] == nums[i]))continue;
			int r = n - 1;
			int l = i + 1;
			while(l<r){
				int total = nums[i] + nums[l] + nums[r];
				if(total < 0){
					l++;
				}else if(total > 0){
					r--;
				}else{
					output.add(Arrays.asList(nums[i], nums[l], nums[r]));
					
					while(l<r && nums[l] == nums[l+1])l++;
					while(l<r && nums[r] == nums[r-1])r--;
                    l++;
                    r--;
			}
		}
    }
    return output;
    }
	
}