package PracticeQuestion;

public class a520 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("FFFFFFFFFFFFFFFFFFFFf"));
    }

    // Detect Capital
    public static boolean detectCapitalUse(String word) {
        int lower_range_start = 'a';
        int lower_range_end = 'z';

        int upper_range_start = 'A';
        int upper_range_end = 'Z';
        char[] wordArray = word.toCharArray();

        for (int i = 1; i < wordArray.length; i++) {
            if (upper_range_start <= wordArray[0] && wordArray[0] <= upper_range_end) {
                if (lower_range_start <= wordArray[1] && wordArray[1] <= lower_range_end) {
                    if (upper_range_start <= wordArray[i] && wordArray[i] <= upper_range_end) {
                        return false;
                    }
                } else {
                    if (lower_range_start <= wordArray[i] && wordArray[i] <= lower_range_end) {
                        return false;
                    }
                }
            } else {
                if (upper_range_start <= wordArray[i] && wordArray[i] <= upper_range_end) {
                    return false;
                }
            }
        }
        return true;
    }
}
