package NeetcodeDSASheet.ArrayAndHashing;

public class ValidSudoko {
    //in this we will basically make a full empty suduko 
    //and we will fill position as we move accross sample,
    //if a position is repeated twice then it means that it is not a valid suduko
    public boolean isValidSudoku(char[][] board) {
        int[][] box = new int[9][9]; //for 3X3 matrix
        int[][] row = new int[9][9]; //for all the rows
        int[][] cols = new int[9][9]; //for all the cols
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c] == '.'){
                    continue;
                }
                int pos = board[r][c] - '1';
                if(row[r][pos] == 1){
                    return false; //this means it contains duplicate
                }
                row[r][pos] = 1; //marking it as visited
                if(cols[pos][c] == 1){
                    return false;
                }
                cols[pos][c] = 1;
                int idx = r/3 * 3 + c/3;
                if(box[idx][pos] == 1) {
                    return false;
                }
                box[idx][pos] = 1;
            }
        }
        return true;
    }
}
