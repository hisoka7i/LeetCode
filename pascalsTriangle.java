import java.util.ArrayList;
import java.util.List;


public class pascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for(int i=0;i<numRows-1;i++){
            ArrayList<Integer> dummy = new ArrayList<>();
            dummy.add(0);
            dummy.addAll(res.get(res.size()-1));
            dummy.add(0);
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<dummy.size()-1;j++){
                row.add(dummy.get(j)+dummy.get(j+1));
            }
            res.add(row);
        }
        return res;
    }
}
