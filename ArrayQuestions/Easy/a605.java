package ArrayQuestions;
public class a605 {
    public static void main(String[] args) {
        int[] sample = {1,0,0,0,1};
        System.out.println(plant(sample, 2));
    }
    public static boolean plant(int[] sample,int n){
        //This question was asked in google
        if(n==0)return false;
        for(int i=0;i<sample.length;i++){
            if(sample[i]==0&&(i==0 || sample[i-1]==0)&& (i==sample.length-1 || sample[i+1]==0)){
                sample[i]=1;
                n--;
                if(n==0)return true;
            }
        }
        return false;
    }
}
