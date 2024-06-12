package PracticeQuestion;

import java.io.*;
public class a191 {
    public static void main(String[] args) {
        hammingWeight(11);
    }
    public static int hammingWeight(int n) {
        String binary_string = Integer.toBinaryString(n);
        int count = 0;
        for(char ch: binary_string.toCharArray()){
            if(ch == '1'){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
}
