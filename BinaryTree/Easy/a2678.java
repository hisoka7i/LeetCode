package BinaryTree.Easy;

public class a2678 {
    public static void main(String[] args) {
        String str = "7868190130M7522";
        int age = Integer.parseInt(str.substring(11, 13));

        System.out.println(age);
    }
    public static int countSeniors(String[] details) {
        int count = 0;
        for(String current: details){
                int age = Integer.parseInt(current.substring(11, 13));
                if(age>60)count++;
        }
        return count;
    }
}
