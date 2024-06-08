package ArrayQuestions;
public class a2609 {
    public static void main(String[] args) {
        String sample = "000011101100001111";
        System.out.println(binaryBalance(sample));
    }
    public static int binaryBalance(String sample){
        int max_size=0;
        int ptr1=0,ptr2=1;
        while (ptr2<sample.length()) {
            if(sample.charAt(ptr1)=='0'&sample.charAt(ptr2)=='1'){
                if(ptr2-ptr1+1>max_size){
                    max_size=ptr2-ptr1+1;
                }
                ptr2++;
                ptr1--;
                if(ptr1<0){
                    ptr1=ptr2-1;
                }
            }else if(sample.charAt(ptr2)=='0'){
                ptr1=ptr2;
                ptr2++;
            }else{
                ptr1=ptr2-1;
                ptr2++;
            }
        }
        return max_size;
    }
}
