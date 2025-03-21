class a2161{
    public int[] pivotArray(int[] nums, int pivot) {

    }
    public int[] bF_pivotArray(int[] nums, int pivot) {
        int pcount = 0;
        int[] output = new int[nums.length];
        int lpointer = 0;
        int hpointer = 0;
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < pivot){
                output[lpointer] = nums[i];
                lpointer++;
            }else if(nums[i] == pivot){
                pcount++;
            }else{
                if(flag == false){
                    hpointer = i;
                    flag = true;
                }
            }
        }
        if(pcount == 0){
            return nums;
        }
        while(pcount > 0){
            output[lpointer++] = pivot;
            pcount--;
        }
        for(; hpointer<nums.length;hpointer++){
            if(nums[hpointer] > pivot)
                output[lpointer++] = nums[hpointer];
        }
        return output;
    }
}