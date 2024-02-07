package String;

public class Combination {
     //This will only work as a combination if all the letters are different
    public static void main(String[] args) {
        combineOne("", "null");
        combineTwo("", "abcd");
    }
    public static void combineOne(String prefix,
     String str){
        if(str.length()>0){
            System.out.println(prefix+str.charAt(0));
            combineOne(prefix+str.charAt(0),str.substring(1));
            combineOne(prefix, str.substring(1));
        }
    }
   
    public static void combineTwo(String prefix,String str){
        System.out.println(prefix);
        for(int i=0;i<str.length();i++){
            combineTwo(prefix+str.charAt(i), str.substring(i+1));
        }
    }
}
