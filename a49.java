import java.util.*;

public class a49 {
    static List<List<String>> output = new ArrayList<>();
    static List<String> sampleList = null;
    public static void main(String[] args) {
        String cat = "cat";
        String[] sample = {"eat","tea","tan","ate","nat","bat"};
        sampleList = Arrays.asList(sample);
        System.out.println(sampleList);
        List<String> example = new ArrayList<>();
        Iterator<String> itr = sampleList.iterator();
        while(itr.hasNext()){
            String str = itr.next();
            combineTwo(str.toCharArray(), str.length(), example);
            output.add(example);
            example.removeAll(example);
        }
        System.out.println(output);
    }
    public static void combineTwo(char[] str,int n, List<String> example){
        if(n==1){
            String xx = str.toString();
            for(String cc: sampleList){
                if(cc.equals(xx)){
                    System.out.println("This is working");
                    example.add(xx);
                }
            }
            return;
        }
        for(int i=0;i<n;i++){
            swap(str, i, n-1);
            combineTwo(str, n-1,example);
            swap(str, i, n-1);
        }
    }
    public static void swap(char[] str,int i,int j){
        char temp = str[i];
        str[i]=str[j];
        str[j]=temp;
    }
}
