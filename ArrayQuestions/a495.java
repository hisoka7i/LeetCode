package ArrayQuestions;
public class a495 {
    public static void main(String[] args) {
        int[] sample = {1,2};
        System.out.println(poisonDuration(sample, 3));
    }
    public static int poisonDuration(int[] a,int d){
        if(d==0)return d;
        int duration = 0;
        for(int i=0;i<a.length-1;i++){
            if(a[i+1]<=a[i]+d-1){
                duration+=a[i+1]-a[i];
            }else{
                duration += d;
            }
        }
        return duration+d;
    }
}
