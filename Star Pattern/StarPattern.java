public class StarPattern{
    public static void main(String[] args){
        pattern18(5);

    }
    static void pattern11(int n){
        for(int row=0;row<2*n;row++){
            int totalColsInRow = row>n?2*n-row:row;
            int totalSpaces = n-totalColsInRow;
            for(int s=0;s<totalSpaces;s++){
                System.out.print(" ");
            }
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern12(int n){
        for(int row=0;row<2*n-1;row++){
            int totalColsInRow = row>n-1?row-(n-2):n-row;
            int totalSpace = row>(n-1)?n-totalColsInRow:row;
            for(int s=0;s<totalSpace;s++){
                System.out.print(" ");
            }
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern13(int n){
        for(int row=0;row<n;row++){
            int totalColsInRow = row+1;
            int totalSpace = (n-totalColsInRow);
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("*");
            }
            for(int s=0;s<totalSpace*2;s++){
                System.out.print(" ");
            }
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern14(int n){
        for(int row=0;row<n;row++){
            int totalColsInRow = n-row;
            int totalSpace = (n-totalColsInRow);
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("*");
            }
            for(int s=0;s<totalSpace*2;s++){
                System.out.print(" ");
            }
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern15(int n){
        for(int row=0;row<n-1;row++){
            int totalColsInRow = row+1;
            int totalSpace = (n-totalColsInRow);
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("*");
            }
            for(int s=0;s<totalSpace*2;s++){
                System.out.print(" ");
            }
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int row=0;row<n;row++){
            int totalColsInRow = n-row;
            int totalSpace = (n-totalColsInRow);
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("*");
            }
            for(int s=0;s<totalSpace*2;s++){
                System.out.print(" ");
            }
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern17(int n){
        for(int row=0;row<n;row++){
            int totalColsInRow = row+1;
            for(int c=0;c<totalColsInRow;c++){
                if(row==n-1){
                    System.out.print("*");
                }
                else if(c==0||c==totalColsInRow-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    static void pattern18(int n){
        for(int row=0;row<n;row++){
            int totalColsInRow = n-row;
            for(int s=totalColsInRow-1;s>=0;s--){
                if(row==0){
                    System.out.print("*");
                }
                else if(s==(n-row-1)|| s==0){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}