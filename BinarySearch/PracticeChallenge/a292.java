package BinarySearch.PracticeChallenge;

public class a292 {
    //nim game
    public static void main(String[] args) {
        
    }
    boolean canWinNim(int n) {
        //If it is not divisible by 4, you can win by strategically leaving your opponent with a multiple of 4 stones on their turn.
        return (n%4!=0);
    }
}
