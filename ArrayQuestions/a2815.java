package ArrayQuestions;
public class a2815 {
    public static void main(String[] args){
        int[] arr = {51,71,17,24,42};
        int n = arr.length;
        int max = arr[0];
        for(int i=0;i<n-1; i++){
            for(int j=i+1;j<n;j++){
                int sum = arr[i]+arr[j];
                if(sum>10 && sum<100){
                    if(sum/10 == sum%10){
                        if(sum>max){
                            max=sum;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
