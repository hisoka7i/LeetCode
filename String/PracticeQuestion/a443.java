package PracticeQuestion;

public class a443 {
    public static void main(String[] args) {
        char[] ar = {'a','a','b','b','c','c','c'};
        System.out.println(compress(ar));
    }

    public static int compress(char[] chars){
        int n = chars.length;
        StringBuilder stringB = new StringBuilder();

        int frequency = 1;
        for(int i=0;i<n;i++){
            char current = chars[i];
            while(i<n-1 && chars[i]==chars[i+1]){
                i++;
                frequency++;
            }
            stringB.append(current);
            if(frequency>1)
                stringB.append(frequency);
            
            frequency = 1;
        }
        char[] compressedString = stringB.toString().toCharArray();

        for(int i=0;i<compressedString.length;i++){
            chars[i]=compressedString[i];
        }
        return compressedString.length;
    }

    //This is wrong implementation

    public static int compress2(char[] chars) {
        int p1 = 0, p2 =0;
        int length = 0;
        int answer = 0;
        while (p2<chars.length) {
            if(chars[p1]==chars[p2]){
                p2++;
                length++;
            }else{
                if(length==0){
                    answer++;
                    p1=p2;
                }else{
                    answer++;
                    while(length>0){
                        answer += length%10;
                        length = length/10;
                    }
                    p1=p2;
                }
            }
        }
        return answer;
    }
}
