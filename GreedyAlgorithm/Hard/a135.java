package GreedyAlgorithm.Hard;

public  class  a135{
    public int candy(int[] ratings) {
        if(ratings.length == 0)
            return  0;
        if(ratings.length == 1)
            return 1;
        int i = 1, n= ratings.length, sum = 1;
        while(i < n){
            if(ratings[i] == ratings[i-1]){
                //this is the case .for the slant one
                sum+=1;
                i++;
                continue;
            }
            int peak = 1;
            while(i<n && ratings[i]>ratings[i-1]){
                //this means it is an increasing scope;
                peak++;
                sum += peak;
                i++;
            }
            int down = 1;
            while(i<n && ratings[i]<ratings[i-1]){
                //this means it is an decreasing slope
                sum += down;
                down++;
                i++;
            }
            if(down > peak ){
                sum += down - peak;
            }
        }
        return  sum;
    }
}