public class MaxRepeatingSub {
    public static void main(String[] args) {
        System.err.println(new MaxRepeatingSub().maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        while(sequence.contains(word)){
            sequence =  sequence.replaceFirst(word, "");
            count++;
        }
        return count;
    }
}
