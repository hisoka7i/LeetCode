import java.util.Arrays;

public class a135 {
    //there was a problem in my understanding which was that, I thought
    //the number should be greater than both the neighbour, which is not true
    public int candy(int[] ratings) {
        int[] answer = new int[ratings.length];
        Arrays.fill(answer, 1);

        //for increasing left to right
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                answer[i] = answer[i-1]+1;
            }
        }

        //for increasing right to left 
        for(int i = ratings.length - 2; i >= 0;i--){
            if(ratings[i] > ratings[i + 1]){
                answer[i] = Math.max(answer[i], answer[i+1]+1);
            }
        }

        return Arrays.stream(answer).sum();
    }

    public boolean is_higher(int[] rating, int index){
        
        if(index == rating.length -1 ){
            return rating[index] > rating[index-1] ? true: false;
        }
        return ((rating[index-1] < rating[index]) || (rating[index+1] < rating[index])) ? true: false;
    }
}
