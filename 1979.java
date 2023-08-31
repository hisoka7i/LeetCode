class a1979{
    public static void main(String[] args){
        int[] arr = {3,4,52,2,9};
        int min = arr[0];
        int max = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(gcd(min,max));
    }
    static int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd((b%a),a);
    }
}