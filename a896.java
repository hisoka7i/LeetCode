public class a896{
    public boolean isMonotonic(int[] nums) {
        if(nums.length==0)return false; //These are edge cases(bottom 2 lines)
        if(nums.length==1)return true;
        if(nums.length==2)return true;
        int n = nums.length;
        int i=0;
        int check = 0;
        while(i<n-1){
            if(nums[i+1]!=nums[i]){
                check = nums[i+1]-nums[i];
                break;
            }
            i++;
        }
        if(check==0)return true;
        i=1;
        if(check>0){
            while(i<n-1){
                if((nums[i+1]-nums[i])<0){
                    return false;
                }
                i++;
            }
        }
        else{
            while(i<n-1){
                if((nums[i+1]-nums[i])>0){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
