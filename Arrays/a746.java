public class a746 {
    public static void main(String[] args) {
        int[] sample = {10,15,20};
        System.out.println(minCost(sample));
    }
    //This solution will not work for all cases
    //this question requires dynamic programming concept 
    public static int minCost(int[] sample){
        int sum1 = 0,sum2 = 0,p1 = 0,p2=p1+1,p3=p1+2;
        if(sample.length==1)return sample[0];
        if(sample.length==2) return sample[0]<sample[1]?sample[0]:sample[1];

        int output = sample[p1];
        while(p3<sample.length){
            sum1 += sample[p1]+sample[p2];
            sum2 += sample[p1]+sample[p3];
            if(sum1<sum2){
                p1=p2;
                sum2=sum1;
            }else{
                p1=p3;
                sum1=sum2;
            }
            output+=sample[p1];
            System.out.println(p3);
            p2=p1+1;
            p3=p1+2;
            
        }
        System.out.println(output);
        return sum1<sum2?sum1:sum2;
    }
}
