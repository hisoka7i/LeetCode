package PracticeQuestion;

public class a492 {
    public static void main(String[] args) {
        
    }
    static int[] constructRectangle(int area) {
        int i = (int) Math.sqrt(area);
        
        //this is more of a math question
        for(;i>=0;i--){
            if(area % i ==0){
                return new int[]{area/i,i};
            }
        }
        return new int[]{area,1};
    }
}
