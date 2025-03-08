package LeetcodeStreak.Easy;

import LinkedList.Mediun.a2;

public class a2379 {
    public static void main(String[] args) {
        String str = "BWWWBB";
        a2379 obj = new a2379();
        System.out.println(obj.minimumRecolors(str, 6));
    }
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        char[] arr = blocks.toCharArray();
        for(int i=0;i<arr.length;i++){
            int j = i + k - 1;
            if(j>=arr.length){
                break;
            }
            int whites = countWhites(arr, i, j);
            min = Math.min(min, whites);
        } 
        return min;
    }
    public int countWhites(char[] blocks, int i, int j){
        int count = 0;
        for(int x=i;x<=j;x++){
            if(blocks[x]=='W'){
                count++;
            }
        }
        return count;
    }
}
