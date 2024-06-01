package ArrayQuestions;
public class MissingAndRepeatingNumbers {
    public static void main(String[] args) {
        int[] sample = {1,2,2,3};
        findMissingRepeatingNumbers(sample);
    }
    public static int[] findMissingRepeatingNumbers(int[] n){
        int[] output = new int[2];
        int[] index = new int[n.length];
        for(Integer i: n){
            index[i-1]+=1;
        }
        for(int i=0;i<index.length;i++){
            if(index[i]==0)output[1]=i+1;
            if(index[i]==2)output[0]=i+1;
        }
        System.out.println(output[0]);
        System.out.println(output[1]);
        return output;
    }
}
