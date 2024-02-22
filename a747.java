public class a747 {
    public static void main(String[] args) {
        int[] sample = {0,0,1,2};
        System.out.println(check(sample));
    }

    //2ms solution
    public static int check(int[] sample){
        Integer max1 = null;
        Integer max2 = null;
        for(int i=0;i<sample.length;i++){
            if(max1==null || sample[i]>sample[max1]){
                max2 = max1;
                max1 = i;
            }
            else if(max2==null || sample[i]>sample[max2]){
                max2=i;
            }
        }
        System.out.println(max1);
        if(sample[max1] >= (2*sample[max2]))return max1;
        return -1;
    }
}
